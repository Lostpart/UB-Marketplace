package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;


@RestController
public class LoginController {

    final UserManager userManager;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    public LoginController(UserManager userManager) {
        this.userManager = userManager;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    public String recoverPass(
            @RequestParam(value="username") String username,
            @RequestParam(value="password") String password
    ) {
        logger.info(String.format("Recovering login request from %s", username));

        boolean valid = userManager.loginVerification(username, password);

        if (valid) {
            return "redirect:home.html";
        }
        else {
            return "redirect:login_error.html";
        }
    }

}
