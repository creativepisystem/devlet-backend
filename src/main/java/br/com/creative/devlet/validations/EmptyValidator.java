package br.com.creative.devlet.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmptyValidator implements
        ConstraintValidator<Empty, Object> {

    @Override
    public void initialize(Empty contactNumber) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value != null && value instanceof  String){
            String s = (String) value;
            return s.length() > 0;
        }else{
            return value != null;
        }
    }

}