package com.ubmarketplace.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CategorizeItemResponse {

    private List<CategorizeItemResponse.CategorizetemResponseItem> item;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CategorizetemResponseItem {
        private String itemId;
        private String name;
        private CategorizeItemResponse.CategorizeItemResponseItemOwner owner;
        private String category;
        private String description;
        private Double price;
        private List<String> images;
        private String meetingPlace;
        private Long createdTime;

    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CategorizeItemResponseItemOwner {
        private String username;
        private String displayName;
    }
}
