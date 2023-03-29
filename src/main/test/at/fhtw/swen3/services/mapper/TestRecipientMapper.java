package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRecipientMapper {
    Recipient recipient = new Recipient().city("Wien").name("Vasilije").country("Österreich").postalCode("1200").street("Wexstrasse");

    @Test
    void testDTOToEntity() {
        RecipientEntity entity = RecipientMapper.INSTANCE.dtoToEntity(recipient);

        assertEquals(recipient.getCity(), entity.getCity());
        assertEquals(recipient.getName(), entity.getName());
        assertEquals(recipient.getCountry(), entity.getCountry());
        assertEquals(recipient.getPostalCode(), entity.getPostalCode());
        assertEquals(recipient.getStreet(), entity.getStreet());
    }

    @Test
    void testEntityToDTO() {
        RecipientEntity entity = RecipientMapper.INSTANCE.dtoToEntity(recipient);
        Recipient newRecipient = RecipientMapper.INSTANCE.entityToDto(entity);

        assertEquals(entity.getCity(), newRecipient.getCity());
        assertEquals(entity.getName(), newRecipient.getName());
        assertEquals(entity.getCountry(), newRecipient.getCountry());
        assertEquals(entity.getPostalCode(), newRecipient.getPostalCode());
        assertEquals(entity.getStreet(), newRecipient.getStreet());
    }
}
