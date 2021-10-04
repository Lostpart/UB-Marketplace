package com.ubmarketplace.app.database;

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
public class Add_User_Credential {

    @Autowired
    private MongoClient mongoClient;

    //print the results of the find Operation
    /*Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            System.out.println(document.toJson());
        }
    };*/

    //username - new user's username
    //email - new user's email
    //password - new user's password
    public Document userCredential(String username, String email, String password) {

        Document newUser = new Document("username", username).append("email", email).append("password", password);

        return newUser;
    }

    //find user with email address
    /*public Document findUser(String email){
        MongoDatabase database = mongoClient.getDatabase("class_activity");
        MongoCollection<Document> collection = database.getCollection("class_activity");
    }*/

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
