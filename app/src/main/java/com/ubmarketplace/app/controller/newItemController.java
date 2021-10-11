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
public class newItemController {

    final UserRepository userRepository;
    final UserManager userManager;
    final ItemRepository itemRepository;
    final ItemManager itemManager;

    @Autowired
    public newItemController(UserRepository userRepository, UserManager userManager, ItemRepository itemRepository, ItemManager itemManager){
        this.userRepository = userRepository;
        this.userManager = userManager;
        this.itemRepository = itemRepository;
        this.itemManager = itemManager;}

    @RequestMapping(value = "/newItem", method = RequestMethod.GET)
    private String received(
            /*@RequestParam(name = "itemId") String itemId,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "owner") User owner,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "price") Double price,
            @RequestParam(name = "imageFilePath") String imageFilePath,
            @RequestParam(name = "meetingPlace") String meetingPlace,
            @RequestParam(name = "createdTime") Long createdTime*/
            ){

        // newItem = "Added item is " + itemManager.addNewItem(itemId, name, owner, description, price, imageFilePath, meetingPlace, createdTime);
        //System.out.println(newItem);

        User user1 = userRepository.findByUsername("kyle");

        Item item1 = new Item();
        item1.setItemId("3");
        item1.setDescription("This is a book");
        item1.setCreatedTime((long) 12345);
        item1.setName("Book");
        item1.setMeetingPlace("North");
        item1.setOwner(user1);
        item1.setImageFilePath("http://");
        item1.setPrice(25.0);
        itemRepository.insert(item1);


        return "redirect:/allitem";
    }
}
