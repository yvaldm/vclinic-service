package com.yvaldm.vclinic.api;

import javax.validation.constraints.NotNull;

/**
 * Request containing user signup information
 *
 * @author valeryyakovlev
 */
public class SignupRequest {

    @NotNull
    private final String email;

    @NotNull
    private final String password;

    public SignupRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
