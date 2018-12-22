package com.yvaldm.vclinic.entity;

/**
 * Entity object holding user registration information
 *
 * @author valery.yakovlev
 */
public class UserRegistration {

    private final long id;
    private final String email;
    private final String password;
    private final int code;

    public UserRegistration(long id, String email, String password, int code) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getCode() {
        return code;
    }

    public String getPassword() {
        return password;
    }
}
