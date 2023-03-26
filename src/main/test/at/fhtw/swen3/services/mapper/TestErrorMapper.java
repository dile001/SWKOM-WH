package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.services.dto.Error;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestErrorMapper {
    private final Error error = new Error().errorMessage("error");

    @Test
    void testDTOToEntity() {
        assertEquals(error.getErrorMessage(), ErrorMapper.INSTANCE.dtoToEntity(error).getErrorMessage());
    }

    @Test
    void testEntityToDTO() {
        ErrorEntity entity = ErrorMapper.INSTANCE.dtoToEntity(error);
        assertEquals(entity.getErrorMessage(), ErrorMapper.INSTANCE.entityToDto(entity).getErrorMessage());
    }
}
