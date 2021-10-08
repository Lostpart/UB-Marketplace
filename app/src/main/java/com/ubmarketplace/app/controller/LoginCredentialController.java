package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.manager.UserManager;
import com.ubmarketplace.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginCredentialController {

    final UserRepository userRepository;
    final UserManager userManager;

    @Autowired
    public LoginCredentialController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userManager = new UserManager(userRepository);
    }

    @RequestMapping("/login")
    private ModelAndView received(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
    ) {

        System.out.println(username);       //only for test
        System.out.println(password);       //only for test

        boolean valid = userManager.loginVerification(username, password);

        ModelAndView modelAndView = new ModelAndView();

        if (valid) {
            modelAndView.setViewName("login.html");     //Waiting for the landing screen
        } else {
            modelAndView.setViewName("login_error.html");
        }
        return modelAndView;
    }

}
