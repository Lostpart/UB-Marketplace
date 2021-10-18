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
    final ItemRepository itemRepository;

    @Autowired
    public NewItemController(UserManager userManager, ItemManager itemManager, UserRepository userRepository, ItemRepository itemRepository){
        this.userManager = userManager;
        this.itemManager = itemManager;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    @RequestMapping(value = "/api/newitem", method = RequestMethod.POST)

    //waiting for FE stuff of listing new Item
    /*private NewItemResponse newItem(@RequestBody NewItemRequest newItemRequest){
        Item item = itemManager.addNewItem(
                newItemRequest.getName(),
                newItemRequest.getOwner(),
                newItemRequest.getDescription(),
                newItemReqeust.getPrice(),
                newItemRequest.getImageFilePath(),
                newItemRequest.getMeetingPlace())

        return NewItemResponse.builder().item(item).build();
    }*/

    private String received(){
        User user1 = User.builder().username("kyle").password("asdasd").build();
        userRepository.insert(user1);

        Item item1 = new Item();
        item1.setDescription("This is a Laptop");
        item1.setName("Laptop");
        item1.setMeetingPlace("Student Union");
        item1.setOwner(user1);
        item1.setImageFilePath("https://cdn.pixabay.com/photo/2014/05/02/21/49/laptop-336373_1280.jpg");
        item1.setPrice(150.0);
        itemRepository.insert(item1);

        return "redirect:/allitem";
    }
}
