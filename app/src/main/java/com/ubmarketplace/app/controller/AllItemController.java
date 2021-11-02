package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.dto.AllItemResponse;
import com.ubmarketplace.app.manager.ImageManager;
import com.ubmarketplace.app.manager.ItemManager;
import com.ubmarketplace.app.manager.UserManager;
import com.ubmarketplace.app.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AllItemController {

    final ImageManager imageManager;
    final ItemManager itemManager;
    final UserManager userManager;

    @Autowired
    public AllItemController(ImageManager imageManager, ItemManager itemManager, UserManager userManager) {
        this.imageManager = imageManager;
        this.itemManager = itemManager;
        this.userManager = userManager;
    }

    @RequestMapping(value = "/api/allitem", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public AllItemResponse allItem(){

        // Get the queryResult
        List<Item> queryResult = itemManager.getAllItem();

        // Convert List<Item> to List<AllItemResponse.AllItemResponseItem>
        List<AllItemResponse.AllItemResponseItem> response = queryResult.parallelStream()
                .map(item -> AllItemResponse.AllItemResponseItem.builder()
                        .itemId(item.getItemId())
                        .name(item.getName())
                        .owner(AllItemResponse.AllItemResponseItemOwner.builder()
                                .userId(item.getUserId())
                                .displayName(userManager.getDiisplayName(item.getUserId()))
                                .build())
                        .category(item.getCategory())
                        .description(item.getDescription())
                        .price(item.getPrice())
                        .images(item.getImages().parallelStream()
                                .map(imageManager::getThumbUrl)
                                .collect(Collectors.toList()))
                        .meetingPlace(item.getMeetingPlace())
                        .createdTime(item.getCreatedTime())
                        .build())
                .collect(Collectors.toList());

        return AllItemResponse.builder().item(response).build();
    }

}
