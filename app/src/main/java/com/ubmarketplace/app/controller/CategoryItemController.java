package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.dto.AllItemResponse;
import com.ubmarketplace.app.dto.CategorizeItemRequest;
import com.ubmarketplace.app.dto.CategorizeItemResponse;
import com.ubmarketplace.app.manager.ImageManager;
import com.ubmarketplace.app.manager.ItemManager;
import com.ubmarketplace.app.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoryItemController {

    final ImageManager imageManager;
    final ItemManager itemManager;

    @Autowired
    public CategoryItemController(ImageManager imageManager, ItemManager itemManager) {
        this.imageManager = imageManager;
        this.itemManager = itemManager;
    }

    @RequestMapping(value = "/api/categoryitem", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public CategorizeItemResponse categorizeItem(@RequestBody CategorizeItemRequest request){

        // Get the queryResult
        List<Item> queryResult = itemManager.getCategoryItem(request.getCategorize());

        // Convert List<Item> to List<AllItemResponse.AllItemResponseItem>
        List<CategorizeItemResponse.CategorizetemResponseItem> response = queryResult.parallelStream()
                .map(item -> CategorizeItemResponse.CategorizetemResponseItem.builder()
                        .itemId(item.getItemId())
                        .name(item.getName())
                        .owner(CategorizeItemResponse.CategorizeItemResponseItemOwner.builder()
                                .username(item.getUserId())
                                .displayName(item.getDisplayName())
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

        return CategorizeItemResponse.builder().item(response).build();
    }
}
