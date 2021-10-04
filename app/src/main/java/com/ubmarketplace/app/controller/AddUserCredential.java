package com.ubmarketplace.app.controller;

import com.mongodb.Block;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PreDestroy;
import javax.print.Doc;
import java.util.logging.Logger;

@Controller
public class AddUserCredential {

    @Autowired
    private MongoClient mongoClient;

    //username - new user's username
    //email - new user's email
    //password - new user's password
    public Document userCredential(String username, String email, String password) {

        Document newUser = new Document("username", username).append("email", email).append("password", password);

        return newUser;
    }

    @RequestMapping("/addnewuser")
    @ResponseBody
    public String index(){
        String enteredUsername = "Kyle Sung";
        String enteredEmail = "asdsad@buffalo.edu";
        String enteredPassword = "123456789";

        Document newUser = userCredential(enteredUsername, enteredEmail, enteredPassword);
        mongoClient.getDatabase("class_activity").getCollection("class_activity").insertOne(newUser);

        return("added new user = " + newUser);
    }
}
