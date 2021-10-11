package com.ubmarketplace.app.manager;

import com.google.inject.Singleton;
import com.ubmarketplace.app.model.Item;
import com.ubmarketplace.app.model.User;
import com.ubmarketplace.app.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
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


    public Item addNewItem(@Nonnull String itemId, @Nonnull String name, @Nonnull User owner, @Nonnull String description, @Nonnull Double price, @Nonnull String imageFilepath, @Nonnull String meetingPlace, @Nonnull Long createdTime){
        Item item = Item.builder().itemId(itemId).name(name).owner(owner).description(description).price(price).imageFilePath(imageFilepath).meetingPlace(meetingPlace).createdTime(createdTime).build();
        itemRepository.insert(item);
        return item;
    }

    public List<Item> getAllItem()
    {
        return itemRepository.findAll();
    }
}
