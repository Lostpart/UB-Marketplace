package com.ubmarketplace.app.manager;

import com.google.inject.Singleton;
import com.mongodb.client.result.DeleteResult;
import com.ubmarketplace.app.model.User;
import com.ubmarketplace.app.repository.UserRepository;
import lombok.NonNull;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
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

    public User getUserByUserId(@NonNull String userId) {
        if(userId.isEmpty()){
            log.info("Empty userId when getUserByUserId");
            throw new InvalidParameterException("Empty username or password");
        }
        User user = userRepository.findById(userId);
        if (user == null){
            log.warning(String.format("Error when get user information for user %s", userId));
            throw new InvalidParameterException("Error when get user information");
        }
        return user;
    }

    public User addNewUser(@NonNull String username, @NonNull String password, @NonNull String displayName){
        if(username.isEmpty() || password.isEmpty() || displayName.isEmpty()){
            log.info(String.format("Empty username or password or display name when creating new account for %s", username));
            throw new InvalidParameterException("Empty username or password or displayName");
        }

        User user = User.builder().userId(username).role("User").password(password).displayName(displayName).build();

        log.info(String.format("Creating new account for %s", username));

        try {
            userRepository.insert(user);
        } catch (DuplicateKeyException e) {
            log.warning(String.format("Failed to create new account for %s, an account with same username already exist", username));
            throw new InvalidParameterException("Failed to create new account, an account with same username already exist");
        }
        return user;
    }

    public String getUserRole(@NotNull String userId){
        if(userId.isEmpty()){
            throw new InvalidParameterException("Empty username");
        }

        //In order to check the role is admin or user, display username as "Admin", if the user role is admin
        //if(userRepository.findById(userId).getRole().equals("Admin")){
        //    User tmp = userRepository.findById(userId);
        //   tmp.setDisplayName(getUserRole(tmp.getUserId()));
        //    userRepository.save(tmp);
        //}
        return userRepository.findById(userId).getRole();
    }

    public String getDiisplayName(@NotNull String username){
        if (username.isEmpty()){
            throw new InvalidParameterException("Empty username");
        }
        return userRepository.findById(username).getDisplayName();
    }

    public User updateUser(@NonNull String username, @NonNull String password, @NonNull String displayName) {
        if(username.isEmpty()){
            log.info("Empty username");
            throw new InvalidParameterException("Empty username");
        }
        log.info(String.format("Updating account for %s", username));

        User old_user = userRepository.findById(username);

        DeleteResult delete = userRepository.remove(old_user);
        if (!delete.wasAcknowledged()){
            log.info(String.format("Fail to delete account for %s", old_user.getUserId()));
            throw new InvalidParameterException("Fail to delete");
        }

        User updated_user;

        if (password.isEmpty() && !displayName.isEmpty()){
            updated_user = User.builder().userId(username).password(old_user.getPassword()).displayName(displayName).build();
        }
        else if (displayName.isEmpty() && !password.isEmpty()){
            updated_user = User.builder().userId(username).password(password).displayName(old_user.getDisplayName()).build();
        }
        else if (displayName.isEmpty()){
            updated_user = User.builder().userId(username).password(old_user.getPassword()).displayName(old_user.getDisplayName()).build();
        }
        else {
            updated_user = User.builder().userId(username).password(password).displayName(displayName).build();
        }



        try {
            userRepository.insert(updated_user);
        } catch (DuplicateKeyException e) {
            log.warning(String.format("Failed to create new account for %s, an account with same username already exist", username));
            throw new InvalidParameterException("Failed to update account, an account with same username already exist");
        }

        return userRepository.findById(username);
    }
}