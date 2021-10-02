package com.ubmarketplace.app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.ubmarketplace.app.manager.*;
import java.util.*;


@Controller
public class LoginCredentialController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String recoverPass(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        System.out.println(username);   //for testing
        System.out.println(password);   //for testing

        UserManager usermanager = new UserManager();
        boolean valid = usermanager.loginVerification(username, password);

        if (valid) {
            return "redirect:login.html";     //Waiting for the landing screen
        }
        else {
            return "redirect:login_error.html";
        }
    }

}
