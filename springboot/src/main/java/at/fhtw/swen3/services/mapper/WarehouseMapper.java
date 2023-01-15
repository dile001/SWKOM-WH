package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseMapper{
    WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);

    @Mapping(source = "locationCoordinates", target = "locationCoordinates")//TODO proveri
    @Mapping(source = "nextHops", target = "nextHops")//TODO proveri
    Warehouse entityToDto(WarehouseEntity entity);

    @Mapping(source = "locationCoordinates", target = "locationCoordinates")//TODO proveri
    @Mapping(source = "nextHops", target = "nextHops")//TODO proveri
    WarehouseEntity dtoToEntity(Warehouse o);
}