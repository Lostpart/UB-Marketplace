package com.ubmarketplace.app.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class User {
    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;
}
