package com.ubmarketplace.app.dal;

import com.ubmarketplace.app.model.Item;

import java.util.List;

public interface ItemDAL {
    void insert(Item item);

    void remove(Item item);

    List<Item> findAll();

    Item findByItemID(String itemId);
}