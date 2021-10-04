package com.ubmarketplace.app.controller;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PreDestroy;
import java.util.logging.Logger;

@Controller
public class DatabaseTestController {

    @Autowired
    private MongoClient mongoClient;

    @RequestMapping("/databasetest")
    @ResponseBody
    public String index() {
        StringBuilder databaseNameBuilder = new StringBuilder();
        StringBuilder dataNameBuilder = new StringBuilder();
        MongoIterable<String> listDatabaseNames = mongoClient.listDatabaseNames();
        MongoIterable<String> listCollectionNames = mongoClient.getDatabase("class_activity").listCollectionNames();
        FindIterable<Document> dataincollection = mongoClient.getDatabase("class_activity").getCollection("class_activity").find(new Document());

        Document newUser = new Document("username", "username").append("email", "email").append("password", "password");

        mongoClient.getDatabase("class_activity").getCollection("class_activity").deleteMany(newUser);

        mongoClient.getDatabase("class_activity").getCollection("class_activity").insertOne(newUser);

        System.out.println(mongoClient.getDatabase("class_activity").getCollection("class_activity").find(newUser).explain());

        for (String database : listDatabaseNames) {
            databaseNameBuilder.append(" | ").append(database);
        }
        for (String collection : listCollectionNames){
            databaseNameBuilder.append(" | ").append(collection);
        }

        for(Document a : dataincollection){
            dataNameBuilder.append(" | ").append(a);
        }
        mongoClient.close();
        return String.format("List Database Names: %s", databaseNameBuilder) + String.format("★Data in selected collection: %s", dataNameBuilder) + "★";
    }
}
