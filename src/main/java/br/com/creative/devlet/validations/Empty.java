package br.com.creative.devlet.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmptyValidator.class)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Empty {
    String message() default "Field dont't can be empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
