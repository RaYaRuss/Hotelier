package com.example.hotelier.model.dto;

import com.example.hotelier.model.validation.FieldMatch;
import com.example.hotelier.model.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords should match."
)
public record UserRegistrationDTO (@NotEmpty String firstName,
                                   @NotEmpty String lastName,
                                   @NotNull @Email @UniqueUserEmail String email,
                                   String password,
                                   String confirmPassword,
                                   String travelAgencyName){

    public String fullName() {
        return firstName + " " + lastName;
    }
}
