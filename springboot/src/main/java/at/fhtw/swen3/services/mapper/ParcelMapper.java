package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.HopArrival;
import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.model.entites.RecipientEntity;
import at.fhtw.swen3.model.entites.ParcelEntity;
import at.fhtw.swen3.model.entites.HopArrivalEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;

import java.util.ArrayList;
import java.util.List;

public class ParcelMapper implements Mapper {
    @Override
    public RecipientEntity recipientEntity(Recipient recipient) {
        return new RecipientEntity(recipient.getName(), recipient.getStreet(), recipient.getPostalCode(), recipient.getCity(), recipient.getCountry());
    }

    @Override
    public HopArrivalEntity hopArrivalEntity(HopArrival hopArrival) {
        return new HopArrivalEntity(hopArrival.getCode(), hopArrival.getDescription() , hopArrival.getDateTime());
    }

    @Override
    public List<HopArrivalEntity> hopArrivalEntities(List<HopArrival> hopArrivalList) {
        List<HopArrivalEntity> hopArrivalEntities = new ArrayList<>();
        for (HopArrival hopArrival : hopArrivalList) {
            hopArrivalEntities.add(hopArrivalEntity(hopArrival));
        }
        return hopArrivalEntities;
    }

    @Override
    public ParcelEntity parcelEntity(Parcel parcel, NewParcelInfo newParcelInfo, TrackingInformation trackingInformation) {
        return new ParcelEntity(
                newParcelInfo.getTrackingId(),
                parcel.getWeight(),
                recipientEntity(parcel.getRecipient()),
                recipientEntity(parcel.getSender()),
                trackingInformation.getState(),
                hopArrivalEntities(trackingInformation.getVisitedHops()),
                hopArrivalEntities(trackingInformation.getFutureHops()));
    }
}
