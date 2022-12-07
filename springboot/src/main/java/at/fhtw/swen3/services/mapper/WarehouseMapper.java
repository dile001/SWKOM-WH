package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;

public class WarehouseMapper extends AbstractMapper<WarehouseEntity, Warehouse> {

    @Override
    public Warehouse entityToDto(WarehouseEntity entity) {
        return null;
    }

    @Override
    public WarehouseEntity dtoToEntity(Warehouse o) {
        return null;
    }
}