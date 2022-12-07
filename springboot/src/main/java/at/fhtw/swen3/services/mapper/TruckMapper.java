package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;

public class TruckMapper extends AbstractMapper<TruckEntity, Truck> {

    @Override
    public Truck entityToDto(TruckEntity entity) {
        return null;
    }

    @Override
    public TruckEntity dtoToEntity(Truck o) {
        return null;
    }
}