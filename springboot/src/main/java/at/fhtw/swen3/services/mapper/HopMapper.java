package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.Hop;

public class HopMapper extends AbstractMapper<HopEntity, Hop> {

    @Override
    public Hop entityToDto(HopEntity entity) {
        return null;
    }

    @Override
    public HopEntity dtoToEntity(Hop o) {
        return null;
    }
}