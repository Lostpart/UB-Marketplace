package com.ubmarketplace.app.manager;

import java.util.logging.Logger;

import com.google.inject.Singleton;
import lombok.NonNull;

@Singleton
public class UserManager {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public boolean loginVerification(@NonNull String userId, @NonNull String password) {
        logger.info(String.format("Verify login information for %s", userId));
        //Call database

        return true; //Do nothing at this time
    }
}
