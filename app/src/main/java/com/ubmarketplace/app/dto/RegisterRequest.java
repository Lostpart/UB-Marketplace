package com.ubmarketplace.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RegisterRequest {
    @NotNull(message = "Username cannot be empty")
    @Email(message = "Email format incorrect")
    private String username;

    @NotNull(message = "Password cannot be empty")
    @Size(min = 8, max = 32, message = "Password must between 8 - 32 characters")
    private String password;
}
