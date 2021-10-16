package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.dto.RegisterRequest;
import com.ubmarketplace.app.dto.RegisterResponse;
import com.ubmarketplace.app.manager.UserManager;
import com.ubmarketplace.app.model.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class RegisterController {
    final UserManager userManager;

    @Autowired
    public RegisterController(UserManager userManager){
        this.userManager = userManager;
    }

    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    private RegisterResponse received(@RequestBody RegisterRequest registerRequest){
        log.info(String.format("Recovering register request from %s", registerRequest.getUsername()));

        User user = userManager.addNewUser(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getDisplayName());

        return RegisterResponse.builder().user(user).build();
    }
}
