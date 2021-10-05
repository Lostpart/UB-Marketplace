package com.ubmarketplace.app.controller;

import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddUserCredentialController {

    @Autowired
    private MongoClient mongoClient;

    //username - new user's username
    //email - new user's email
    //password - new user's password
    public Document userCredential(String username, String email, String password) {

        return new Document("username", username).append("email", email).append("password", password);
    }

    @RequestMapping("/addnewuser")
    @ResponseBody
    public String index(){
        String enteredUsername = "Kyle Sung";
        String enteredEmail = "asdsad@buffalo.edu";
        String enteredPassword = "123456789";
        StringBuilder dataNameBuilder = new StringBuilder();

        MongoDatabase ourDB = mongoClient.getDatabase("class_activity");
        MongoCollection collectionDB = ourDB.getCollection("class_activity");
        Document newUser = userCredential(enteredUsername, enteredEmail, enteredPassword);

        //Delete previous data
        collectionDB.deleteMany(newUser);

        //Add new data
        collectionDB.insertOne(newUser);

        //To check the inserted data into collection
        FindIterable<Document> dataincollection = mongoClient.getDatabase("class_activity").getCollection("class_activity").find(new Document());

        for(Document a : dataincollection){
            dataNameBuilder.append(" | ").append(a);
        }

        return String.format("Data in selected collection is %s", dataNameBuilder);
    }
}
