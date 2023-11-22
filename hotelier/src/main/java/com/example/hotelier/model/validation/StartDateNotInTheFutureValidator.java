package com.example.hotelier.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StartDateNotInTheFutureValidator implements ConstraintValidator<StartDateNotInTheFuture, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        //TODO implementation

        return false;
    }
}
