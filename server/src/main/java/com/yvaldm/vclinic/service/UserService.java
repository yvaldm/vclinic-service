package com.yvaldm.vclinic.service;

/**
 * @author valeryyakovlev
 */
public interface UserService {

    void signup(String email, String password);

    void confirm(String email, int code);
}
