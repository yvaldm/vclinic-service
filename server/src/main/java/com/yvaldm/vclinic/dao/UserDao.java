package com.yvaldm.vclinic.dao;

import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserDao {

    void insert(String email, String password);

    Optional<User> find(String email);

}
