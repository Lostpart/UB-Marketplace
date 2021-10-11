package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.manager.UserManager;
import com.ubmarketplace.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    final UserManager userManager;

    @Autowired
    public RegisterController(UserManager userManager){
        this.userManager = userManager;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private String received(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
    ){
        System.out.println(username);
        System.out.println(password);

        String newUser = "Added user is " + userManager.addNewUser(username, password);

        System.out.println(newUser);

        return "redirect:login.html";
    }
}
