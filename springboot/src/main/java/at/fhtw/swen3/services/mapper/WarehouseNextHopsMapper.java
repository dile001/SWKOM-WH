package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseNextHopsMapper {
    WarehouseNextHopsMapper INSTANCE = Mappers.getMapper(WarehouseNextHopsMapper.class);

    @Mapping(source = "hop",target = "hop")//TODO proveri
    WarehouseNextHops entityToDto(WarehouseNextHopsEntity entity);

    @Mapping(source = "hop",target = "hop")//TODO proveri
    WarehouseNextHopsEntity dtoToEntity(WarehouseNextHops o);
}