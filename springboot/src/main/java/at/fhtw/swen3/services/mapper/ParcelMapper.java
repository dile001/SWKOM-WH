package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.LinkedList;
import java.util.List;

@Mapper
public interface ParcelMapper{
    ParcelMapper INSTANCE= Mappers.getMapper(ParcelMapper.class);

    @Named("hopArrivalListDtoToEntity")
    static List<HopArrivalEntity> hopArrivalListDtoToEntity(List<HopArrival> list){
        LinkedList<HopArrivalEntity> newList= new LinkedList<>();

        for(HopArrival i : list){
            newList.add(HopArrivalMapper.INSTANCE.dtoToEntity(i));
        }
        return newList;
    }

    @Named("hopArrivalListEntityToDto")
    static List<HopArrival> hopArrivalListEntityToDto(List<HopArrivalEntity> list){
        LinkedList<HopArrival> newList= new LinkedList<>();

        for(HopArrivalEntity i : list){
            newList.add(HopArrivalMapper.INSTANCE.entityToDto(i));
        }
        return newList;
    }


    @Mapping(source = "entity.state", target = "state")
    @Mapping(source = "entity.visitedHops", target = "visitedHops", qualifiedByName = "hopArrivalListEntityToDto")
    @Mapping(source = "entity.futureHops", target = "futureHops", qualifiedByName = "hopArrivalListEntityToDto")
    TrackingInformation trackingInformationEntityToDto(ParcelEntity entity);

    @Mapping(source = "entity.sender", target = "sender")
    @Mapping(source = "entity.recipient", target = "recipient")
    @Mapping(source = "entity.weight", target = "weight")
    Parcel entityToDto(ParcelEntity entity);

    @Mapping(source = "trackingInformation.state.", target = "state")
    @Mapping(source = "trackingInformation.visitedHops", target = "visitedHops", qualifiedByName = "hopArrivalListDtoToEntity")
    @Mapping(source = "trackingInformation.futureHops", target = "futureHops", qualifiedByName = "hopArrivalListDtoToEntity")
    @Mapping(source = "parcel.weight", target = "weight")
    @Mapping(source = "parcel.recipient", target = "recipient")
    @Mapping(source = "parcel.sender", target = "sender")
    @Mapping(source = "newParcelInfo.trackingId", target = "trackingId")
    ParcelEntity dtoToEntity(NewParcelInfo newParcelInfo, Parcel parcel, TrackingInformation trackingInformation);
}
