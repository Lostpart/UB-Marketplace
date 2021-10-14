package com.ubmarketplace.app.dao;

import com.mongodb.client.result.DeleteResult;
import com.ubmarketplace.app.model.Item;

import java.util.List;

public interface ItemDao {
    void insert(Item item);

    DeleteResult remove(Item item);

    List<Item> findAll();

    Item findByItemID(String itemId);
}
