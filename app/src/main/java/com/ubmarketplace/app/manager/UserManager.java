package com.ubmarketplace.app.manager;

import com.google.inject.Singleton;
import com.ubmarketplace.app.model.User;
import com.ubmarketplace.app.repository.UserRepository;
import lombok.NonNull;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;

@Singleton
@Component
@Log
public class UserManager {
    final UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean loginVerification(@NonNull String username, @NonNull String password) {
        if (username.isEmpty() || password.isEmpty()) {
            log.info(String.format("Empty username or password when verifying login information for %s", username));
            throw new InvalidParameterException("Empty username or password");
        }

        log.info(String.format("Verify login information for %s", username));

        User user = userRepository.findById(username);

        if (user == null) {
            log.info(String.format("Verify login information for %s, cannot find such user", username));
            return false;
        }

        return password.equals(user.getPassword());
    }

    public User addNewUser(@NonNull String username, @NonNull String password){
        if(username.isEmpty() || password.isEmpty()){
            log.info(String.format("Empty username or password when creating new account for %s", username));
            throw new InvalidParameterException("Empty username or password");
        }
        log.info(String.format("Creating new account for %s", username));

        User user = User.builder().username(username).password(password).build();

        try {
            userRepository.insert(user);
        } catch (DuplicateKeyException e) {
            log.warning(String.format("Failed to create new account for %s, an account with same username already exist", username));
            throw new InvalidParameterException("Failed to create new account, an account with same username already exist");
        }

        return user;
    }
}
