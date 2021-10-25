package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.dto.NewItemRequest;
import com.ubmarketplace.app.dto.NewItemResponse;
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

import static com.ubmarketplace.app.TestStatic.*;


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class NewItemControllerTest {
    @Autowired
    NewItemController newItemController;

    @BeforeAll
    static void setup(@Autowired UserRepository userRepository){
        userRepository.insert(User.builder().username(TEST_USER_NAME_3).password(TEST_PASSWORD_3).build());
    }

    @Test
    public void GIVEN_goodInput_WHEN_add_new_item_THEN_returnCorrectNewItemResponse(@Autowired ItemRepository itemRepository){
        Item item = Item.builder().
                name(TEST_ITEM_NAME_3).
                userId(TEST_USER_NAME_3).
                description(TEST_ITEM_DESCRIPTION_3).
                price(TEST_ITEM_PRICE_3).
                images(TEST_ITEM_IMAGE_3).
                meetingPlace(TEST_ITEM_MEETING_PLACE_3).build();

        NewItemResponse response = newItemController.newItem(
                new NewItemRequest(
                        TEST_ITEM_NAME_3,
                        TEST_USER_NAME_3,
                        TEST_ITEM_DESCRIPTION_3,
                        TEST_ITEM_PRICE_3,
                        TEST_ITEM_IMAGE_3,
                        TEST_ITEM_MEETING_PLACE_3));

        Item testItem = itemRepository.findById(response.getItem().getItemId());

        Assertions.assertEquals(testItem.getName(), item.getName());
        Assertions.assertEquals(testItem.getUserId(), item.getUserId());
        Assertions.assertEquals(testItem.getDescription(), item.getDescription());
        Assertions.assertEquals(testItem.getPrice(), item.getPrice());
        Assertions.assertEquals(testItem.getImages(), item.getImages());
        Assertions.assertEquals(testItem.getMeetingPlace(), item.getMeetingPlace());
    }
}
