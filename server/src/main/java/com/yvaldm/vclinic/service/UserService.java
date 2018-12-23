package com.yvaldm.vclinic.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Service for managing users
 *
 * @author valeryyakovlev
 */
public interface UserService {

    /**
     * Sign up operation
     *
     * @param email
     * @param password
     */
    @Transactional
    void signup(String email, String password);

    /**
     * Confirm sign up with code
     *
     * @param email email
     * @param code  confirmation code
     */
    @Transactional
    void confirm(String email, int code);
}
