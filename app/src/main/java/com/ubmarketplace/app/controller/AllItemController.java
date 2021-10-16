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
    final ItemRepository itemRepository;

    @Autowired
    public AllItemController(ItemManager itemManager, ItemRepository itemRepository) {
        this.itemManager = itemManager;
        this.itemRepository = itemRepository;
    }

    @RequestMapping(value = "/api/allitem", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public List<Item>  response(){

//        ItemRepository itermre = new ItemRepository();
//        JsonManager jsonManager = new JsonManager();
//        ItemManager im = new ItemManager();


//        String content = "";

//        List<Item> items = new ArrayList<>();
//
//        User user1 = new User();
//        user1.setUsername("zzhong");
//        user1.setPassword("123456");
//        Item item1 = new Item();
//        item1.setItemId("3");
//        item1.setDescription("This is a book");
//        item1.setCreatedTime((long) 12345);
//        item1.setName("Book");
//        item1.setMeetingPlace("North");
//        item1.setOwner(user1);
//        item1.setImageFilePath("http://");
//        item1.setPrice(25.0);
//        itemRepository.insert(item1);
//
//        items.add(item1);
//
//        user1 = new User();
//        user1.setUsername("abc");
//        user1.setPassword("12345678");
//        item1 = new Item();
//        item1.setItemId("2");
//        item1.setDescription("This is a car");
//        item1.setCreatedTime((long) 114514);
//        item1.setName("car");
//        item1.setMeetingPlace("South campus");
//        item1.setOwner(user1);
//        item1.setImageFilePath("http://");
//        item1.setPrice(999999.0);
//        itemRepository.insert(item1);
//
//        items.add(item1);



//        content = jsonManager.itemListToJsonString(items);


        return itemManager.getAllItem();
    }


}
