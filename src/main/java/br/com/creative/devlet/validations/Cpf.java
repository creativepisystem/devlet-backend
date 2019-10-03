package br.com.creative.devlet.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfValidator.class)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cpf {
    String value();
    String message() default "Cpf don't match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
