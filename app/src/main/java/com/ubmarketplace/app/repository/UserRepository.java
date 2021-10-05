package com.ubmarketplace.app.repository;

import com.ubmarketplace.app.dal.UserDAL;
import com.ubmarketplace.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements UserDAL {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(User user) {
        mongoTemplate.insert(user);
    }

    @Override
    public void remove(User user) {
        mongoTemplate.remove(user);
    }

    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User findByUsername(String username) {
        return mongoTemplate.findById(username, User.class);
    }

}
