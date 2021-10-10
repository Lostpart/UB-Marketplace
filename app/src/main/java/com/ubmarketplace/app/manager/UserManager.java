package com.ubmarketplace.app.manager;

import com.google.inject.Singleton;
import com.ubmarketplace.app.model.User;
import com.ubmarketplace.app.repository.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;
import java.util.logging.Logger;

@Singleton
@Component
public class UserManager {
    final UserRepository userRepository;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean loginVerification(@NonNull String username, @NonNull String password) {
        if (username.isEmpty() || password.isEmpty()) {
            logger.info(String.format("Empty username or password when verifying login information for %s", username));
            throw new InvalidParameterException("Empty username or password");
        }

        logger.info(String.format("Verify login information for %s", username));

        User user = userRepository.findByUsername(username);

        if (user == null) {
            logger.info(String.format("Verify login information for %s, cannot find such user", username));
        	return false;
        }

        return password.equals(user.getPassword());
    }

    public User addNewUser(@NonNull String username, @NonNull String password){
        if(username.isEmpty() || password.isEmpty()){
            logger.info(String.format("Empty username or password when creating new account for %s", username));
            throw new InvalidParameterException("Empty username or password");
        }

        logger.info(String.format("Creat new account for %s", username));
        User user = User.builder().username(username).password(password).build();
        userRepository.insert(user);
        return user;
    }
}
