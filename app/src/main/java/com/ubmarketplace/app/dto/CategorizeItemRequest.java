package com.ubmarketplace.app.dto;
import lombok.*;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CategorizeItemRequest {
    @NotNull(message = "categorize cant be null")
    private String categorize;
}
