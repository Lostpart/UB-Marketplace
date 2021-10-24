package com.ubmarketplace.app.repository;

import com.ubmarketplace.app.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static com.ubmarketplace.app.TestStatic.TEST_ITEM_ID_1;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_ID_2;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_NAME_1;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_NAME_2;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    void GIVEN_validItem_WHEN_insert_THEN_insertIntoDatabase() {
        // If it doesn't fail, see as a success
        Assertions.assertDoesNotThrow(() -> itemRepository.insert(Item.builder().itemId(TEST_ITEM_ID_1)
                .name(TEST_ITEM_NAME_1).build()));
    }

    @Test
    void GIVEN_validItem_WHEN_remove_THEN_removeFromDatabase() {
        // If it doesn't fail, see as a success
        Assertions.assertDoesNotThrow(() -> itemRepository.remove(Item.builder().itemId(TEST_ITEM_ID_1).build()));
    }

    @Test
    void GIVEN_itemsInDatabase_WHEN_findAll_THEN_findAllItems() {
        itemRepository.insert(Item.builder().itemId(TEST_ITEM_ID_1).name(TEST_ITEM_NAME_1).build());
        itemRepository.insert(Item.builder().itemId(TEST_ITEM_ID_2).name(TEST_ITEM_NAME_2).build());

        List<String> validItemId = new ArrayList<String>(){{
            add(TEST_ITEM_ID_1);
            add(TEST_ITEM_ID_2);
        }};

        List<Item> result = itemRepository.findAll();
        for(Item item : result){
            Assertions.assertTrue(validItemId.contains(item.getItemId()));
        }
    }

    @Test
    void GIVEN_itemsInDatabase_WHEN_findByItemID_THEN_returnTheItem() {
        Item item1 = Item.builder().itemId(TEST_ITEM_ID_1).name(TEST_ITEM_NAME_1).build();
        itemRepository.insert(item1);
        itemRepository.insert(Item.builder().itemId(TEST_ITEM_ID_2).name(TEST_ITEM_NAME_2).build());

        Assertions.assertEquals(item1, itemRepository.findById(TEST_ITEM_ID_1));
    }
}
