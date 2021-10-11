package com.ubmarketplace.app.manager;

import com.google.inject.Singleton;
import com.ubmarketplace.app.model.Item;
import com.ubmarketplace.app.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Singleton
@Component
public class ItemManager {
    final ItemRepository itemRepository;

    @Autowired
    public ItemManager(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }





//    ItemRepository ip = new ItemRepository();

    public List<Item> getALlitem()
    {
        return itemRepository.findAll();
    }
}
