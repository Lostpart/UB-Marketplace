package com.ubmarketplace.app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.ubmarketplace.app.manager.*;


@Controller
public class LoginCredentialController {

    public String username, password;

    @RequestMapping("/login")
    private ModelAndView received(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
    ) {
        this.username = username;
        this.password = password;


        System.out.println(username);       //only for test
        System.out.println(password);       //only for test

        UserManager usermanager = new UserManager();
        boolean valid = usermanager.loginVerification(username, password);

        ModelAndView modelAndView = new ModelAndView();

        if (valid) {
            modelAndView.setViewName("login.html");     //Waiting for the landing screen
        }
        else {
            modelAndView.setViewName("login_error.html");
        }
        return modelAndView;
    }

}
