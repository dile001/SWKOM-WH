package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.services.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseNextHopsMapper {
    WarehouseNextHopsMapper INSTANCE = Mappers.getMapper(WarehouseNextHopsMapper.class);

    @Named("hopToHopEntity")
    static HopEntity hopToHopEntity(Hop hop) {
        if (hop.getClass() == Hop.class) {
            return HopMapper.INSTANCE.dtoToEntity(hop);
        }
        if (hop.getClass() == Truck.class) {
            return TruckMapper.INSTANCE.dtoToEntity((Truck) (hop));
        }
        if (hop.getClass() == Warehouse.class) {
            return WarehouseMapper.INSTANCE.dtoToEntity((Warehouse) (hop));
        }
        if (hop.getClass() == Transferwarehouse.class) {
            return TransferWarehouseMapper.INSTANCE.dtoToEntity((Transferwarehouse) (hop));
        }

        return null;
    }

    @Named("hopEntityToHop")
    public static Hop hopEntityToHop(HopEntity entity) {
        if (entity.getClass() == HopEntity.class) {
            return HopMapper.INSTANCE.entityToDto(entity);
        }
        if (entity.getClass() == TruckEntity.class) {
            return TruckMapper.INSTANCE.entityToDto((TruckEntity) (entity));
        }
        if (entity.getClass() == WarehouseEntity.class) {
            return WarehouseMapper.INSTANCE.entityToDto((WarehouseEntity) (entity));
        }
        if (entity.getClass() == TransferWarehouseEntity.class) {
            return TransferWarehouseMapper.INSTANCE.entityToDto((TransferWarehouseEntity) (entity));
        }
        return null;
    }

    @Mapping(source = "hop", target = "hop", qualifiedByName = "hopEntityToHop")
    WarehouseNextHops entityToDto(WarehouseNextHopsEntity entity);

    @Mapping(source = "hop", target = "hop", qualifiedByName = "hopToHopEntity")
    WarehouseNextHopsEntity dtoToEntity(WarehouseNextHops o);
}