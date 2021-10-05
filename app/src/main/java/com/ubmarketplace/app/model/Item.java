package com.ubmarketplace.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    private String itemId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
    private String name;
    private User owner;
    private String description;
    private Double price;
    private String imageFilePath;
    private String meetingPlace;
    private Long createdTime = Instant.now().toEpochMilli();
}
