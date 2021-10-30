package com.ubmarketplace.app.manager;

import com.google.inject.Singleton;
import com.mongodb.client.result.DeleteResult;
import com.ubmarketplace.app.model.Item;
import com.ubmarketplace.app.repository.ItemRepository;
import lombok.NonNull;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.security.InvalidParameterException;
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

    public Item addNewItem(@NonNull String name,
                           @NonNull String userId,
                           @NonNull String category,
                           @NonNull String description,
                           @NonNull Double price,
                           @NonNull List<String> imageIds,
                           @NonNull String meetingPlace){

        Item item = Item.builder()
                .name(name)
                .userId(userId)
                .category(category)
                .description(description)
                .price(price)
                .images(imageIds)
                .meetingPlace(meetingPlace)
                .build();

        itemRepository.insert(item);
        return item;
    }

    public List<Item> getAllItem()
    {
        return itemRepository.findAll();
    }


    public Boolean deleteItem(@NotNull String itemID){
        Item find = itemRepository.findByItemID(itemID);

        if (find == null){
            throw new InvalidParameterException("No such item");
        }

        DeleteResult result = itemRepository.remove(find);

        if (result.wasAcknowledged()){
            return true;
        }
        else{
            return false;
        }

    }
}
