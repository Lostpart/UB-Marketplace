package com.ubmarketplace.app.repository;

import com.mongodb.client.result.DeleteResult;
import com.ubmarketplace.app.dao.ItemDao;
import com.ubmarketplace.app.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
    public Item findById(String itemId) {
        return mongoTemplate.findById(itemId, Item.class);
    }


    public List<Item> getCategoryItem(String category, String userId, String location, String pricing){
        Criteria criteria = new Criteria();
        if (userId.isEmpty() && category.isEmpty() && location.isEmpty() && pricing.isEmpty()){
            return mongoTemplate.findAll(Item.class);
        }

        if (!userId.isEmpty()){
            criteria.and("userId").is(userId);
        }
        if (!category.isEmpty()){
            criteria = criteria.and("category").is(category);
        }
        if (!location.isEmpty()){
            criteria = criteria.and("meetingPlace").is(location);
        }

        Query query = new Query(criteria);

        if (!pricing.isEmpty()){
            if (pricing.equals("descend")){
                query = query.with(Sort.by(Sort.Order.desc("price")));
            }
            else if (pricing.equals("ascend")){
                query = query.with(Sort.by(Sort.Order.asc("price")));
            }
        }

        List<Item> queryResult = mongoTemplate.find(query, Item.class);

        return queryResult;
    }
}
