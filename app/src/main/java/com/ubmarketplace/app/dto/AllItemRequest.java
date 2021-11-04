package com.ubmarketplace.app.dto;
import lombok.*;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AllItemRequest {
    @NotNull(message = "category cannot be null")
    private String category;

    @NotNull(message = "userID cannot be null")
    private String userId;

    @NotNull(message = "location cannot be null")
    private String location;

    @NotNull(message = "pricing cannot be null")
    private String pricing;

}
