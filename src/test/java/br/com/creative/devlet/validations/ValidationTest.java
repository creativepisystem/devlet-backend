package br.com.creative.devlet.validations;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ValidationTest {
    private static ValidatorFactory validatorFactory;
    private static Validator validator;
    @BeforeClass
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterClass
    public static void close() {
        validatorFactory.close();
    }


    @Test
    public void shouldValidateCpfAndCnpj() {

        ValidationTestModel validationTestModel =new ValidationTestModel();
        validationTestModel.setCnpj("94219573000154");
        validationTestModel.setCpf("023.046.230-85");
        Set<ConstraintViolation<ValidationTestModel>> violations
                = validator.validate(validationTestModel);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void shouldNotValidateCpf() {

        ValidationTestModel validationTestModel =new ValidationTestModel();
        validationTestModel.setCnpj("94219573000154");
        validationTestModel.setCpf("023.046.230-83");
        Set<ConstraintViolation<ValidationTestModel>> violations
                = validator.validate(validationTestModel);

        assertEquals(violations.size(),1);
    }

    @Test
    public void shouldNotValidateCnpj() {

        ValidationTestModel validationTestModel =new ValidationTestModel();
        validationTestModel.setCnpj("94219573000152");
        validationTestModel.setCpf("023.046.230-85");
        Set<ConstraintViolation<ValidationTestModel>> violations
                = validator.validate(validationTestModel);
        assertEquals(violations.size(),1);
    }
}
