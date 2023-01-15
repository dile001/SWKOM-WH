package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelMapper{
    ParcelMapper INSTANCE= Mappers.getMapper(ParcelMapper.class);

    @Mapping(source = "entity.state", target = "state")
    @Mapping(source = "entity.visitedHops", target = "visitedHops")//TODO proveri
    @Mapping(source = "entity.futureHops", target = "futureHops")//TODO proveri
    TrackingInformation trackingInformationEntityToDto(ParcelEntity entity);

    @Mapping(source = "entity.sender", target = "sender")
    @Mapping(source = "entity.recipient", target = "recipient")
    @Mapping(source = "entity.weight", target = "weight")
    Parcel entityToDto(ParcelEntity entity);

    @Mapping(source = "trackingInformation.state.", target = "state")
    @Mapping(source = "trackingInformation.visitedHops", target = "visitedHops")//TODO proveri
    @Mapping(source = "trackingInformation.futureHops", target = "futureHops")//TODO proveri
    @Mapping(source = "parcel.weight", target = "weight")
    @Mapping(source = "parcel.recipient", target = "recipient")
    @Mapping(source = "parcel.sender", target = "sender")
    @Mapping(source = "info.trackingId", target = "trackingId")
    ParcelEntity dtoToEntity(NewParcelInfo newParcelInfo, Parcel parcel, TrackingInformation trackingInformation);
}
