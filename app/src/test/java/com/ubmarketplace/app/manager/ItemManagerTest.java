package com.ubmarketplace.app.manager;

import com.ubmarketplace.app.model.Item;
import com.ubmarketplace.app.model.User;
import com.ubmarketplace.app.repository.ItemRepository;
import com.ubmarketplace.app.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import static com.ubmarketplace.app.Static.*;
import static com.ubmarketplace.app.Static.TEST_ITEM_NAME_1;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class ItemManagerTest {
    @Autowired
    ItemManager itemmanager;

    @BeforeAll
    static void setup(@Autowired ItemRepository itemRepository) {
        itemRepository.insert(Item.builder().itemId(TEST_ITEM_ID_1).name(TEST_ITEM_NAME_1).build());
        itemRepository.insert(Item.builder().itemId(TEST_ITEM_ID_2).name(TEST_ITEM_NAME_2).build());
    }

    @Test
    public void GIVEN_goodInput_WHEN_loginVerification_THEN_returnTrue() {
        List<String> validItemId = new ArrayList<String>(){{
            add(TEST_ITEM_ID_1);
            add(TEST_ITEM_ID_2);
        }};

        List<Item> result = itemmanager.getAllItem();
        for(Item item : result){
            Assertions.assertTrue(validItemId.contains(item.getItemId()));
        }
    }

}
