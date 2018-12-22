package com.yvaldm.vclinic.exceptions;

import com.yvaldm.libs.exceptions.BadRequestException;

public class NotFoundException extends BadRequestException {

    public NotFoundException(String reason, String message) {
        super(reason, message);
    }

    public static NotFoundException userRegistrationNotFound() {
        return new NotFoundException("USER_REGISTRATION_NOT_FOUND", "User registration entry not found");
    }
}
