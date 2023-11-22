package com.example.hotelier.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = StartDateNotInTheFutureValidator.class)
public @interface StartDateNotInTheFuture {

    String message() default "Start data should be in the future";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
