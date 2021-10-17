package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.manager.ItemManager;
import com.ubmarketplace.app.manager.UserManager;
import com.ubmarketplace.app.model.Item;
import com.ubmarketplace.app.model.User;
import com.ubmarketplace.app.repository.ItemRepository;
import com.ubmarketplace.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NewItemController {

    final UserManager userManager;
    final ItemManager itemManager;
    final UserRepository userRepository;

    @Autowired
    public NewItemController(UserManager userManager, ItemManager itemManager, UserRepository userRepository){
        this.userManager = userManager;
        this.itemManager = itemManager;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/api/newitem", method = RequestMethod.POST)

    //waiting for FE stuff of listing new Item
    private NewItemResponse newItem(@RequestBody NewItemRequest newItemRequest){
        Item item = itemManager.addNewItem(
                newItemRequest.getName(),
                newItemRequest.getOwner(),
                newItemRequest.getDescription(),
                newItemReqeust.getPrice(),
                newItemRequest.getImageFilePath(),
                newItemRequest.getMeetingPlace())

        /*User user1 = userRepository.findByUsername("kyle");
        Item item1 = new Item();
        item1.setItemId("3");
        item1.setDescription("This is a book");
        item1.setCreatedTime((long) 12345);
        item1.setName("Book");
        item1.setMeetingPlace("North");
        item1.setOwner(user1);
        item1.setImageFilePath("http://");
        item1.setPrice(25.0);
        itemRepository.insert(item1);*/

        return NewItemResponse.builder().item(item).build();
    }
}
