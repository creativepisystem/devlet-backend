package br.com.creative.devlet.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LengthValidator implements
        ConstraintValidator<Length, String> {

    private Integer min;
    private Integer max;
    @Override
    public void initialize(Length length) {
        min = length.min();
        max = length.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isMinValid = true;
        boolean isMaxValid = true;
        if(value == null){
            return false;
        }
        if(min > 0){
            isMinValid= value.length() >= min;
        }

        if(max > 0){
            isMaxValid = value.length() <= max;
        }
        return  isMaxValid && isMinValid;
    }

}