package com.ubmarketplace.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class NewItemRequest {
    private String itemID;
    private String name;
    private User Owner;
    private String description;
    private Double price;
    private String imageFilePath;
    private String meetingPlace;
    private Long createdTime;
}