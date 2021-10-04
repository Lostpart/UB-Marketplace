package com.ubmarketplace.app.manager;

import com.google.inject.Singleton;
import com.ubmarketplace.app.model.User;
import lombok.NonNull;

import java.security.InvalidParameterException;
import java.util.logging.Logger;

@Singleton
public class UserManager {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public boolean loginVerification(@NonNull String username, @NonNull String password) {
        if(username.isEmpty() || password.isEmpty()){
            logger.info(String.format("Empty username or password when verifying login information for %s", username));
            throw new InvalidParameterException("Empty username or password");
        }

        logger.info(String.format("Verify login information for %s", username));



        User user = query(username);

        return password.equals(user.getPassword());
    }

    //Waiting for database design, a do nothing function at this time
    private User query(String username) {
        return User.builder()
                .username(username)
                .password("GoodPassword")
                .build();
    }
}
