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
public class LoginRequest {
    @NotNull(message = "Username cannot be empty")
    @Email(message = "Format incorrect: Username should be an email")
    private String username;

    @NotNull(message = "Password cannot be empty")
    @Size(min = 64, max = 64, message = "Password must hash with SHA-256 and should be 64 characters long")
    private String password;
}
