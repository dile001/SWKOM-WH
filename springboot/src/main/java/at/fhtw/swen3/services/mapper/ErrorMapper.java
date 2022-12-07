package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.services.dto.Error;

public class ErrorMapper extends AbstractMapper<ErrorEntity, Error> {

    @Override
    public Error entityToDto(ErrorEntity entity) {
        return null;
    }

    @Override
    public ErrorEntity dtoToEntity(Error o) {
        return null;
    }
}
