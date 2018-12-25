package com.yvaldm.vclinic.api;

public class UserResponse {

    private final String email;

    public UserResponse(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
