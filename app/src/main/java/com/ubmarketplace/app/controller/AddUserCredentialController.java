package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.manager.UserDatabaseManager;
import com.ubmarketplace.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddUserCredentialController {

    final UserRepository userRepository;
    final UserDatabaseManager userDatabaseManagerManager;

    @Autowired
    public AddUserCredentialController(UserRepository userRepository){
        this.userRepository = userRepository;
        this.userDatabaseManagerManager = new UserDatabaseManager(userRepository);
    }

    @RequestMapping("/create")
    private ModelAndView received(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
    ){
        System.out.println(username);
        System.out.println(password);

        String newUser = userDatabaseManagerManager.AddNewUser(username, password);

        System.out.println(newUser);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("home.html");

        return modelAndView;
    }
}
