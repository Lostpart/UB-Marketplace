package com.ubmarketplace.app.manager;

import com.google.inject.Singleton;
import com.ubmarketplace.app.model.Item;
import com.ubmarketplace.app.model.User;
import com.ubmarketplace.app.repository.ItemRepository;
import lombok.NonNull;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Singleton
@Component
@Log
public class ItemManager {
    final ItemRepository itemRepository;
    @Autowired
    public ItemManager(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addNewItem(@NonNull itemId, @NonNull String name, @NonNull User owner, @NonNull String description, @NonNull Double price, @NonNull String imageFilepath, @NonNull String meetingPlace){
        Item item = Item.builder().itemId(itemId).name(name).owner(owner).description(description).price(price).imageFilePath(imageFilepath).meetingPlace(meetingPlace).createdTime().build();
        itemRepository.insert(item);
        return item;
    }

    public List<Item> getAllItem()
    {
        return itemRepository.findAll();
    }
}
