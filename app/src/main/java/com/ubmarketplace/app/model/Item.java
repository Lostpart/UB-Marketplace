package com.ubmarketplace.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.apache.commons.lang3.RandomStringUtils;

import static com.ubmarketplace.app.Utils.getCurrentEpochMilli;
import java.util.ArrayList;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Item {
    @Id @Builder.Default
    private String itemId = RandomStringUtils.randomAlphanumeric(8).toLowerCase();
    private String name;
    private User owner;
    private String description;
    private Double price;
    private ArrayList<String> imageFilePath;
    private String meetingPlace;

    @EqualsAndHashCode.Exclude @Builder.Default
    private Long createdTime = getCurrentEpochMilli();
}
