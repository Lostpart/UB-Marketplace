package com.ubmarketplace.app.manager;

import com.ubmarketplace.app.model.Item;
import com.ubmarketplace.app.repository.ItemRepository;

import java.util.List;

public class ItemManager {

    ItemRepository ip = new ItemRepository();

    public List<Item> getALlitem()
    {
        return ip.findAll();
    }
}
