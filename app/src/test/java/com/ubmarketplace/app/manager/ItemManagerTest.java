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
    static void setup(@Autowired ItemRepository itemRepository, @Autowired UserRepository userRepository) {
        userRepository.insert(User.builder().username(TEST_USER_NAME_3).password(TEST_PASSWORD_3).build());
        itemRepository.insert(Item.builder().itemId(TEST_ITEM_ID_1).name(TEST_ITEM_NAME_1).build());
        itemRepository.insert(Item.builder().itemId(TEST_ITEM_ID_2).name(TEST_ITEM_NAME_2).build());
    }

    @Test
    public void GIVEN_goodInput_When_addNewItem_Then_returnTrue(@Autowired ItemRepository itemRepository, @Autowired UserRepository userRepository){
        User TEST_ITEM_OWNER_3 = userRepository.findByUsername(TEST_USER_NAME_3);
        Item item = Item.builder().itemId(TEST_ITEM_ID_3).name(TEST_ITEM_NAME_3).owner(TEST_ITEM_OWNER_3).description(TEST_ITEM_DESCRIPTION_3).price(TEST_ITEM_PRICE_3).imageFilePath(TEST_ITEM_IMAGE_3).meetingPlace(TEST_ITEM_MEETING_PLACE_3).build();

        itemmanager.addNewItem(
                TEST_ITEM_ID_3,
                TEST_ITEM_NAME_3,
                TEST_ITEM_OWNER_3,
                TEST_ITEM_DESCRIPTION_3,
                TEST_ITEM_PRICE_3,
                TEST_ITEM_IMAGE_3,
                TEST_ITEM_MEETING_PLACE_3
        );
        Assertions.assertEquals(itemRepository.findByItemID(TEST_ITEM_ID_3), item);
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
