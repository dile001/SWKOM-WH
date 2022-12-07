package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;

public class RecipientMapper extends AbstractMapper<RecipientEntity, Recipient> {

    @Override
    public Recipient entityToDto(RecipientEntity entity) {
        return null;
    }

    @Override
    public RecipientEntity dtoToEntity(Recipient o) {
        return null;
    }
}