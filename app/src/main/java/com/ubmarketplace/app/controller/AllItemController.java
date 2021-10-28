package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.dto.AllItemResponse;
import com.ubmarketplace.app.manager.ImageManager;
import com.ubmarketplace.app.manager.ItemManager;
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

    @Autowired
    public AllItemController(ImageManager imageManager, ItemManager itemManager) {
        this.imageManager = imageManager;
        this.itemManager = itemManager;
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
                                .username(item.getUserId())
                                .displayName("No Display Name Yet, waiting code merge") // Todo: @Kevin add displayName once you merge displayName
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
                .sorted((x,y) -> (int) (y.getCreatedTime() - x.getCreatedTime()))
                .collect(Collectors.toList());

        return AllItemResponse.builder().item(response).build();
    }

}
