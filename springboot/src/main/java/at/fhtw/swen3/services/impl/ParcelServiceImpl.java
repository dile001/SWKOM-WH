package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.repositories.HopArrivalRepository;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.PredictionService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.exceptions._____notemptyexception.FutureHopsNotEmptyException;
import at.fhtw.swen3.services.exceptions._____notfoundexception.HopNotFoundException;
import at.fhtw.swen3.services.exceptions._____notfoundexception.ParcelNotFoundException;
import at.fhtw.swen3.services.exceptions.bad_____exception.BadAddressException;
import at.fhtw.swen3.services.exceptions.bad_____exception.BadParcelException;
import at.fhtw.swen3.services.exceptions.bad_____exception.BadTrackingIDException;
import at.fhtw.swen3.services.exceptions.duplication_____exception.DuplicationTrackingIDException;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import at.fhtw.swen3.services.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ParcelServiceImpl implements ParcelService {
    private ParcelRepository parcelRepository;
    private HopRepository hopRepository;
    private HopArrivalRepository hopArrivalRepository;
    private RecipientRepository recipientRepository;
    private PredictionService predictionService;

    @Autowired
    public ParcelServiceImpl(HopRepository hopRepository, ParcelRepository parcelRepository, HopArrivalRepository hopArrivalRepository, RecipientRepository recipientRepository, PredictionService predictionService) {
        this.hopRepository = hopRepository;
        this.parcelRepository = parcelRepository;
        this.hopArrivalRepository = hopArrivalRepository;
        this.recipientRepository = recipientRepository;
        this.predictionService = predictionService;
    }


    @Override
    public NewParcelInfo submitNewParcel(Parcel parcel) throws DuplicationTrackingIDException, BadParcelException, BadAddressException, HopNotFoundException {
        try {
            Validator.validate(parcel);
        } catch (ValidationException e) {
            log.error("Bad Parcel: " + e.getMessage());
            throw new BadParcelException("Bad Parcel: " + e.getMessage());
        }

        NewParcelInfo newParcelInfo = new NewParcelInfo().trackingId(UUID.randomUUID().toString());

        if (hopRepository.count() <= 0) {
            log.error("Hops not found!");
            throw new HopNotFoundException("Hops not found!");
        }

        TrackingInformation trackingInformation = predictionService.getTrackingInformation(parcel.getRecipient(), parcel.getSender());

        return saveParcel(newParcelInfo, parcel, trackingInformation);
    }

    @Override
    public NewParcelInfo transferExistingParcel(String trackingId, Parcel parcel) throws DuplicationTrackingIDException, BadParcelException, BadAddressException, HopNotFoundException, BadTrackingIDException {
        try {
            Validator.validate(trackingId);
        } catch (ValidationException e) {
            log.error("Bad Tracking ID: " + e.getMessage());
            throw new BadTrackingIDException("Bad Tracking ID: " + e.getMessage());
        }

        try {
            Validator.validate(parcel);
        } catch (ValidationException e) {
            log.error("Bad Parcel: " + e.getMessage());
            throw new BadParcelException("Bad Parcel: " + e.getMessage());
        }

        NewParcelInfo newParcelInfo = new NewParcelInfo().trackingId(trackingId);

        if (hopRepository.count() <= 0) {
            log.error("Hops not found!");
            throw new HopNotFoundException("Hops not found!");
        }

        TrackingInformation trackingInformation = predictionService.getTrackingInformation(parcel.getRecipient(), parcel.getSender());

        return saveParcel(newParcelInfo, parcel, trackingInformation);
    }

    @Override
    public void reportParcelDelivery(String trackingId) throws BadTrackingIDException, FutureHopsNotEmptyException, ParcelNotFoundException {
        ParcelEntity parcelEntity = getParcelEntity(trackingId);

        if (!parcelEntity.getFutureHops().isEmpty()) {
            throw new FutureHopsNotEmptyException("Parcel cannot be delivered before it hasn't passed all future hops");
        }

        parcelEntity.setState(TrackingInformation.StateEnum.DELIVERED);
        parcelRepository.save(parcelEntity);
    }

    @Override
    public TrackingInformation trackParcel(String trackingId) throws BadTrackingIDException, ParcelNotFoundException {
        return ParcelMapper.INSTANCE.trackingInformationEntityToDto(getParcelEntity(trackingId));
    }

    @Override
    public void reportParcelArrivalAtHop(String trackingId, String code) throws BadTrackingIDException, ParcelNotFoundException, HopNotFoundException {
        ParcelEntity parcelEntity = getParcelEntity(trackingId);

        String hopType = getHopType(code);

        if (!parcelEntity.getFutureHops().get(0).getCode().equals(code)) {
            throw new HopNotFoundException("Hop " + code + " is not the next hop of the parcel " + trackingId + "!");
        }

        switch (hopType) {
            case "truck":
                parcelEntity.setState(TrackingInformation.StateEnum.INTRUCKDELIVERY);
            case "warehouse":
                parcelEntity.setState(TrackingInformation.StateEnum.INTRANSPORT);
            case "transferwarehouse":
                parcelEntity.setState(TrackingInformation.StateEnum.TRANSFERRED);
        }

        HopArrivalEntity hopArrival = parcelEntity.getFutureHops().remove(0);
        hopArrival.setDateTime(OffsetDateTime.now());

        parcelEntity.getVisitedHops().add(hopArrival);
        parcelRepository.save(parcelEntity);
    }

    //HELPER FUNCTIONS
    private ParcelEntity getParcelEntity(String trackingId) throws BadTrackingIDException, ParcelNotFoundException {
        ParcelEntity parcelEntity;

        try {
            Validator.validate(trackingId);
        } catch (ValidationException e) {
            log.error("Bad Tracking ID: " + e.getMessage());
            throw new BadTrackingIDException("Bad Tracking ID: " + e.getMessage());
        }

        try {
            parcelEntity = parcelRepository.findByTrackingId(trackingId).get(0);
        } catch (IndexOutOfBoundsException e) {
            log.error("Parcel " + trackingId + " does not exist");
            throw new ParcelNotFoundException("Parcel " + trackingId + " does not exist");
        }

        return parcelEntity;
    }

    private String getHopType(String code) throws HopNotFoundException {
        if (hopRepository.existsByCode(code)) {
            return hopRepository.getHopTypeByCode(code).get();
        }
        log.error("Hop " + code + " does not exist.");
        throw new HopNotFoundException("Hop " + code + " does not exist.");
    }

    private NewParcelInfo saveParcel(NewParcelInfo newParcelInfo, Parcel parcel, TrackingInformation trackingInformation) throws DuplicationTrackingIDException {
        Optional<String> trackingId = parcelRepository.doesTrackingIdExist(newParcelInfo.getTrackingId());
        if (trackingId.isPresent()) {
            log.error("Tracking-Id " + newParcelInfo.getTrackingId() + " already exists in Database");
            throw new DuplicationTrackingIDException("Tracking-Id already exists");
        }

        ParcelEntity entity = ParcelMapper.INSTANCE.dtoToEntity(newParcelInfo, parcel, trackingInformation);

        entity.setRecipient(getRecipient(parcel.getRecipient()));
        entity.setSender(getRecipient(parcel.getSender()));

        hopArrivalRepository.saveAll(entity.getVisitedHops());
        hopArrivalRepository.saveAll(entity.getFutureHops());

        parcelRepository.save(entity);

        return newParcelInfo;
    }

    private RecipientEntity getRecipient(Recipient recipient) {
        RecipientEntity recipientEntity = findRecipient(recipient);
        if (recipientEntity == null) {
            recipientEntity = recipientRepository.save(RecipientMapper.INSTANCE.dtoToEntity(recipient));
        }
        return recipientEntity;
    }

    private RecipientEntity findRecipient(Recipient recipient) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("id");
        Optional<RecipientEntity> entity = recipientRepository.findOne(Example.of(RecipientMapper.INSTANCE.dtoToEntity(recipient), matcher));
        return entity.orElse(null);
    }
}
