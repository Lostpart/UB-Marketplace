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
     public NewItemResponse newItem(@RequestBody NewItemRequest newItemRequest){
        Item item = itemManager.addNewItem(
                newItemRequest.getName(),
                newItemRequest.getUserId(),
                newItemRequest.getDescription(),
                newItemRequest.getPrice(),
                newItemRequest.getImages(),
                newItemRequest.getMeetingPlace());

        return NewItemResponse.builder().item(item).build();
    }
}
