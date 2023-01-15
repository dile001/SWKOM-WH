package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferWarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransferWarehouseMapper extends CoordinateToPointMapper {
    TransferWarehouseMapper INSTANCE = Mappers.getMapper(TransferWarehouseMapper.class);

    @Mapping(source = "locationCoordinates",target = "locationCoordinates", qualifiedByName = "pointToGeoCoordinate")
    Transferwarehouse entityToDto(TransferWarehouseEntity entity);
    @Mapping(source = "locationCoordinates",target = "locationCoordinates", qualifiedByName = "geoCoordinateToPoint")
    TransferWarehouseEntity dtoToEntity(Transferwarehouse o);
}