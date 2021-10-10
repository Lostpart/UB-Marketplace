package com.ubmarketplace.app.manager;


import com.ubmarketplace.app.model.User;
import com.ubmarketplace.app.repository.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.InvalidParameterException;
import java.util.logging.Logger;

public class UserDatabaseManager {
    final UserRepository userRepository;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    public UserDatabaseManager(UserRepository userRepository) {this.userRepository = userRepository;}

    public String AddNewUser(@NonNull String username, @NonNull String password){
        if(username.isEmpty() || password.isEmpty()){
            logger.info(String.format("Empty username or password when creating new account for %s", username));
            throw new InvalidParameterException("Empty username or password");
        }

        logger.info(String.format("Creat new account for %s", username));

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userRepository.insert(user);

        return "Added user is " + user.toString();
    }

}
