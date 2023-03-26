package at.fhtw.swen3.services.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import java.util.Set;

public class Validator {
    private static javax.validation.Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static void validate(Object o) throws ValidationException{
        Set<ConstraintViolation<Object>> violationSet = validator.validate(o);
        if(!violationSet.isEmpty()){
            StringBuilder error = new StringBuilder("Validation errors found:\n");

            for(ConstraintViolation<Object> violation:violationSet){
                error.append("Message: ").append(violation.getMessage());
            }

            throw new ValidationException(error.toString());
        }
    }
}
