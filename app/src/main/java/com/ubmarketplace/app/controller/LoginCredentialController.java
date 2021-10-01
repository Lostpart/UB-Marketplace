package com.ubmarketplace.app.controller;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

import java.util.*;

@Controller
public class LoginCredentialController {
    @RequestMapping("/login")
    public ModelAndView received(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
    ) {
        System.out.println(username);
        System.out.println(password);

        boolean valid = false;
        ModelAndView modelAndView = new ModelAndView();
        if (valid) {

            modelAndView.setViewName("login.html");
        }
        else {

            modelAndView.setViewName("login_error.html");
        }
        return modelAndView;
    }




}
