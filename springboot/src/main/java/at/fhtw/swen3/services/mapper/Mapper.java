package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.HopArrival;
import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.model.entites.HopArrivalEntity;
import at.fhtw.swen3.model.entites.ParcelEntity;
import at.fhtw.swen3.model.entites.RecipientEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;

import java.util.List;

public interface Mapper {
    RecipientEntity recipientEntity(Recipient recipient);
    HopArrivalEntity hopArrivalEntity(HopArrival hopArrival);
    List<HopArrivalEntity> hopArrivalEntities(List<HopArrival> hopArrivalList);
    ParcelEntity parcelEntity(Parcel parcel, NewParcelInfo newParcelInfo, TrackingInformation trackingInformation);
}
