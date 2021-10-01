package com.ubmarketplace.app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginCredentialController {
    @RequestMapping("/login")
    public ModelAndView received(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
    ) {
        System.out.println(username);       //only for test
        System.out.println(password);       //only for test

        boolean valid = false;

        //TODO: determine user input credential vaild or not, if vaild, change @vaild to true

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
