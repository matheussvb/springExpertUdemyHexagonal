package br.com.matheussvb.config.validation;

import br.com.matheussvb.config.validation.constraintvalidation.NotEmptyListValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = NotEmptyListValidator.class)
public @interface NotEmptyList {
}
