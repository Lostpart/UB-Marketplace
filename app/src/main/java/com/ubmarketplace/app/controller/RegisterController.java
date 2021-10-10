package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    final UserManager userManager;

    @Autowired
    public RegisterController(UserManager userManager){
        this.userManager = userManager;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    private ModelAndView received(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
    ){
        System.out.println(username);
        System.out.println(password);

        String newUser = "Added user is " + userManager.addNewUser(username, password);

        System.out.println(newUser);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("home.html");

        return modelAndView;
    }
}
