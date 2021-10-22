package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.dto.NewItemRequest;
import com.ubmarketplace.app.dto.NewItemResponse;
import com.ubmarketplace.app.manager.ItemManager;
import com.ubmarketplace.app.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class NewItemController {

    final ItemManager itemManager;

    @Autowired
    public NewItemController(ItemManager itemManager){
        this.itemManager = itemManager;
    }

    @RequestMapping(value = "/api/newItem", method = RequestMethod.POST)
     private NewItemResponse newItem(@RequestBody NewItemRequest newItemRequest){
        Item item = itemManager.addNewItem(
                newItemRequest.getName(),
                newItemRequest.getOwner(),
                newItemRequest.getDescription(),
                newItemRequest.getPrice(),
                newItemRequest.getImageFilePath(),
                newItemRequest.getMeetingPlace());

        return NewItemResponse.builder().item(item).build();
    }

    //For local test
    /*private NewItemResponse newItem(){
        List<String> images = new ArrayList<String>();
        images.add("https://book1");
        images.add("https://book2");
        User owner = User.builder().username("kyle").build();

        newItemRequest => it assumes that it receives new item data information from FE
        NewItemRequest newItemRequest = new NewItemRequest("book", owner, "This is book", 10.0, images, "SU");


        Item item = itemManager.addNewItem(
                newItemRequest.getName(),
                newItemRequest.getOwner(),
                newItemRequest.getDescription(),
                newItemRequest.getPrice(),
                newItemRequest.getImageFilePath(),
                newItemRequest.getMeetingPlace());

        return NewItemResponse.builder().item(item).build();
    }*/
}
