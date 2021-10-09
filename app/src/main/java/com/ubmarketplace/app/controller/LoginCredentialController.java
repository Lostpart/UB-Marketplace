package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.manager.UserManager;
import com.ubmarketplace.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String recoverPass(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        System.out.println("username: " + username);   //for testing only
        System.out.println("Password: " + password);   //for testing only

        boolean valid = userManager.loginVerification(username, password);

        if (valid) {
            return "redirect:home.html";
        }
        else {
            return "redirect:login_error.html";
        }
    }

}
