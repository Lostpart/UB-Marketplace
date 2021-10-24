package com.ubmarketplace.app.dto;

import com.ubmarketplace.app.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class NewItemRequest {
    @NotNull(message = "Itemname cannot be empty")
    private String name;

    private User Owner; //TODO: change this to `String userId`, so FE only need to provide a userId (a.k.a username, email)

    @NotNull(message = "Description cannot be empty")
    private String description;

    @NotNull(message = "Price cannot be empty")
    @Min(value = 0, message = "Price must be greater than 0")
    @Max(value = 10000, message = "Price must be less than 10000")
    private Double price;

    @NotNull(message = "Please attach at least one image")
    private ArrayList<String> images;

    @NotNull(message = "Meeting place cannot be empty")
    private String meetingPlace;
}