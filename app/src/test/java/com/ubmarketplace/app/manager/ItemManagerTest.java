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

import java.util.ArrayList;
import java.util.List;

import static com.ubmarketplace.app.TestStatic.*;

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
        Item item = itemmanager.addNewItem(
                TEST_ITEM_NAME_3,
                TEST_USER_NAME_3,
                TEST_ITEM_CATEGORY_3,
                TEST_ITEM_DESCRIPTION_3,
                TEST_ITEM_PRICE_3,
                TEST_ITEM_IMAGE_3,
                TEST_ITEM_MEETING_PLACE_3
        );
        Assertions.assertEquals(itemRepository.findById(item.getItemId()), item);

        //Remove added item in order to avoid of interrupting other test.
        itemRepository.remove(itemRepository.findById(item.getItemId()));
    }
    
    @Test
    public void GIVEN_goodInput_WHEN_loginVerification_THEN_returnTrue() {
        List<String> validItemId = new ArrayList<String>(){{
            add(TEST_ITEM_ID_1);
            add(TEST_ITEM_ID_2);
            add(TEST_ITEM_ID_3);
        }};

        List<Item> result = itemmanager.getAllItem();
        System.out.println(result);
        for(Item item : result){
            Assertions.assertTrue(validItemId.contains(item.getItemId()));
        }
    }

    @Test
    public void Remove_Item_THEN_returnTrue(@Autowired ItemRepository itemRepository){
        Assertions.assertEquals(itemmanager.deleteItem(TEST_ITEM_ID_1), true);
        itemRepository.insert(Item.builder().itemId(TEST_ITEM_ID_1).name(TEST_ITEM_NAME_1).build());

    }

    @Test
    public void Remove_ItemTwice_THEN_returnTrue(@Autowired ItemRepository itemRepository){
        Assertions.assertEquals(itemmanager.deleteItem(TEST_ITEM_ID_1), true);
        Assertions.assertThrows(InvalidParameterException.class, () -> itemmanager.deleteItem(TEST_ITEM_ID_1));
    }

}
