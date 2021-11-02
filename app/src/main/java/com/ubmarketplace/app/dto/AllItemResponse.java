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
public class AllItemResponse {
    private List<AllItemResponseItem> item;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AllItemResponseItem {
        private String itemId;
        private String name;
        private AllItemResponseItemOwner owner;
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
    public static class AllItemResponseItemOwner {
        private String userId;
        private String displayName;
    }
}
