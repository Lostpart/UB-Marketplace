package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.manager.ItemManager;
import com.ubmarketplace.app.model.Item;
import com.ubmarketplace.app.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllItemController {

    final ItemManager itemManager;

    @Autowired
    public AllItemController(ItemManager itemManager, ItemRepository itemRepository) {
        this.itemManager = itemManager;
    }

    @RequestMapping(value = "/api/allitem", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public List<Item>  response(){

        //TODO: After Item remove User object, consider include user information separately.
        // For example: return a List of item, also a list of user information
        // The list of user information should contain User object of those name is in List of item
        // (Don't return the entire User table!)
        return itemManager.getAllItem();
    }


}
