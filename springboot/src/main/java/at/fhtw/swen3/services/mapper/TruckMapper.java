package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import at.fhtw.swen3.services.dto.Truck;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TruckMapper{
    TruckMapper INSTANCE = Mappers.getMapper(TruckMapper.class);

    @Mapping(source = "locationCoordinates",target = "locationCoordinates")//TODO proveri
    Truck entityToDto(TruckEntity entity);
    @Mapping(source = "locationCoordinates",target = "locationCoordinates")//TODO proveri
    TruckEntity dtoToEntity(Truck o);
}