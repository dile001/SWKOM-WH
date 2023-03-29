package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class TestRecipientRepository {
    @Autowired
    RecipientRepository repository;

    public Recipient dummyRecipient;

    @Test
    public void testDB() {
        dummyRecipient = new Recipient().city("Wien").name("Vasilije").country("Österreich").postalCode("1200").street("Wexstrasse");
        RecipientEntity recipientEntity = repository.save(RecipientMapper.INSTANCE.dtoToEntity(dummyRecipient));
        Optional<RecipientEntity> optionalRecipientEntity = repository.findById(recipientEntity.getId());
        assert (optionalRecipientEntity.isPresent());
        repository.delete(recipientEntity);
    }
}
