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
    @NotNull(message = "Itemname cannot be empty")
    private String name;

    private User Owner;

    @NotNull(message = "Description cannot be empty")
    private String description;

    @NotNull(message = "Price cannot be empty")
    private Double price;

    @NotNull(message = "Please attach the item image")
    private String imageFilePath;

    @NotNull(message = "Meeting place cannot be empty")
    private String meetingPlace;
}