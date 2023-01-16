package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.services.dto.NewParcelInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestValidator {

    @Test
    void testValidationNewParcelInfo(){
        NewParcelInfo newParcelInfo = new NewParcelInfo();
        newParcelInfo.setTrackingId("ABCDEFGHI");

        assertDoesNotThrow(()->Validator.validate(newParcelInfo));
    }
}
