package com.ubmarketplace.app.repository;

import com.mongodb.client.result.DeleteResult;
import com.ubmarketplace.app.dao.ItemDao;
import com.ubmarketplace.app.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository implements ItemDao {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ItemRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void insert(Item item) {
        mongoTemplate.insert(item);
    }

    @Override
    public DeleteResult remove(Item item) {
        return mongoTemplate.remove(item);
    }

    @Override
    public List<Item> findAll() {
        return mongoTemplate.findAll(Item.class); //Todo: Should be paginated
    }

    @Override
    public Item findByItemID(String itemId) {
        return mongoTemplate.findById(itemId, Item.class);
    }
}
