package br.com.creative.devlet.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Empty
@Documented
@Constraint(validatedBy = LengthValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {
    String message() default "Length of text is invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int min() default -1;
    int max() default -1;

}
