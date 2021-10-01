package com.ubmarketplace.app.manager;

import java.util.logging.Logger;

import lombok.NonNull;

public class UserManager {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public boolean loginVerification(@NonNull String userid, @NonNull String password) {
        //Call database

        return true; //Do nothing at this time
    }
}
