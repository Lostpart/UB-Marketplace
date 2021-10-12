package com.ubmarketplace.app.dao;

import com.mongodb.client.result.DeleteResult;
import com.ubmarketplace.app.model.User;

import java.util.List;

public interface UserDao {
    void insert(User user);

    DeleteResult remove(User user);

    List<User> findAll();

    User findByUsername(String username);
}
