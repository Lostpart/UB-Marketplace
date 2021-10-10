package com.ubmarketplace.app.dal;

import com.ubmarketplace.app.model.User;

import java.util.List;

public interface UserDAL {
    void insert(User user);

    void remove(User user);

    List<User> findAll();

    User findByUsername(String username);
}