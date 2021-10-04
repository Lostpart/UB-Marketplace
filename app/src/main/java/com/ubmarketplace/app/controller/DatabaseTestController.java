package com.ubmarketplace.app.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
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
        MongoIterable<String> listDatabaseNames = mongoClient.listDatabaseNames();
        MongoIterable<String> listCollectionNames = mongoClient.getDatabase("class_activity").listCollectionNames();
        mongoClient.getDatabase("class_activity").getCollection("class_activity").insertOne(new Document("name", "eli"));

        System.out.println(mongoClient.getDatabase("class_activity").getCollection("class_activity").countDocuments());
        for (String database : listDatabaseNames) {
            databaseNameBuilder.append(" | ").append(database);
        }
        for (String collection : listCollectionNames){
            databaseNameBuilder.append(" | ").append(collection);
        }
        mongoClient.close();
        return String.format("List Database Names: %s", databaseNameBuilder);
    }
}
