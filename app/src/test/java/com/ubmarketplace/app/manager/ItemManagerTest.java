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
import java.util.Arrays;
import java.util.List;

import static com.ubmarketplace.app.TestStatic.TEST_IMAGE_IMAGE_ID_1;
import static com.ubmarketplace.app.TestStatic.TEST_IMAGE_IMAGE_ID_2;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_4;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_5;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_CATEGORY_3;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_CATEGORY_4;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_DESCRIPTION_3;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_DESCRIPTION_4;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_ID_1;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_ID_2;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_ID_3;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_ID_4;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_ID_5;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_IMAGE_3;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_MEETING_PLACE_3;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_MEETING_PLACE_4;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_NAME_1;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_NAME_2;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_NAME_3;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_NAME_4;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_PHONE_NUMBER_FORMATTED_4;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_PRICE_3;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_PRICE_4;
import static com.ubmarketplace.app.TestStatic.TEST_ITEM_USER_ID_4;
import static com.ubmarketplace.app.TestStatic.TEST_PASSWORD_3;
import static com.ubmarketplace.app.TestStatic.TEST_USER_ID_3;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class ItemManagerTest {
    @Autowired
    ItemManager itemManager;

    @BeforeAll
    static void setup(@Autowired ItemRepository itemRepository, @Autowired UserRepository userRepository) {
        userRepository.insert(User.builder().userId(TEST_USER_ID_3).password(TEST_PASSWORD_3).build());
        itemRepository.insert(Item.builder().itemId(TEST_ITEM_ID_1).name(TEST_ITEM_NAME_1).build());
        itemRepository.insert(Item.builder().itemId(TEST_ITEM_ID_2).name(TEST_ITEM_NAME_2).build());
        itemRepository.insert(TEST_ITEM_4);
        itemRepository.insert(TEST_ITEM_5);
    }

    @Test
    public void GIVEN_goodInput_When_addNewItem_Then_returnTrue(@Autowired ItemRepository itemRepository, @Autowired UserRepository userRepository) {
        Item item = itemManager.addNewItem(
                TEST_ITEM_NAME_3,
                TEST_USER_ID_3,
                TEST_ITEM_CATEGORY_3,
                TEST_ITEM_DESCRIPTION_3,
                TEST_ITEM_PRICE_3,
                TEST_ITEM_IMAGE_3,
                TEST_ITEM_MEETING_PLACE_3,
                ""
        );
        Assertions.assertEquals(itemRepository.findById(item.getItemId()), item);

        //Remove added item in order to avoid of interrupting other test.
        itemRepository.remove(itemRepository.findById(item.getItemId()));
    }

    @Test
    public void GIVEN_goodInput_WHEN_loginVerification_THEN_returnTrue() {
        List<String> validItemId = Arrays.asList(TEST_ITEM_ID_1, TEST_ITEM_ID_2, TEST_ITEM_ID_3, TEST_ITEM_ID_4,
                TEST_ITEM_ID_5);

        List<Item> result = itemManager.getAllItem();
        System.out.println(result);
        for (Item item : result) {
            Assertions.assertTrue(validItemId.contains(item.getItemId()));
        }
    }

    @Test
    public void Remove_Item_THEN_returnTrue(@Autowired ItemRepository itemRepository) {
        Assertions.assertEquals(itemManager.deleteItem(TEST_ITEM_ID_1), true);
        itemRepository.insert(Item.builder().itemId(TEST_ITEM_ID_1).name(TEST_ITEM_NAME_1).build());

    }

    @Test
    public void Remove_ItemTwice_THEN_returnTrue(@Autowired ItemRepository itemRepository) {
        Assertions.assertEquals(itemManager.deleteItem(TEST_ITEM_ID_1), true);
        Assertions.assertThrows(InvalidParameterException.class, () -> itemManager.deleteItem(TEST_ITEM_ID_1));
    }

    @Test
    public void GIVEN_validItemId_WHEN_getItemById_THEN_returnItem() {
        Item item = itemManager.getItemById(TEST_ITEM_ID_4);
        Assertions.assertEquals(TEST_ITEM_ID_4, item.getItemId());
        Assertions.assertEquals(TEST_ITEM_NAME_4, item.getName());
        Assertions.assertEquals(TEST_ITEM_USER_ID_4, item.getUserId());
        Assertions.assertEquals(TEST_ITEM_CATEGORY_4, item.getCategory());
        Assertions.assertEquals(TEST_ITEM_DESCRIPTION_4, item.getDescription());
        Assertions.assertEquals(TEST_ITEM_PRICE_4, item.getPrice());
        Assertions.assertEquals(TEST_IMAGE_IMAGE_ID_1, item.getImages().get(0));
        Assertions.assertEquals(TEST_IMAGE_IMAGE_ID_2, item.getImages().get(1));
        Assertions.assertEquals(TEST_ITEM_MEETING_PLACE_4, item.getMeetingPlace());
        Assertions.assertEquals(TEST_ITEM_PHONE_NUMBER_FORMATTED_4, item.getContactPhoneNumber());
    }

    @Test
    public void GIVEN_inValidItemId_WHEN_getItemById_THEN_throwException() {
        Assertions.assertThrows(InvalidParameterException.class,
                () -> itemManager.getItemById(""));

        Assertions.assertThrows(InvalidParameterException.class,
                () -> itemManager.getItemById("NotValidItemID"));
    }
}
