package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.dto.RegisterRequest;
import com.ubmarketplace.app.dto.RegisterResponse;
import com.ubmarketplace.app.manager.UserManager;
import com.ubmarketplace.app.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.ubmarketplace.app.Static.TEST_PASSWORD_1;
import static com.ubmarketplace.app.Static.TEST_USER_NAME_1;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegisterControllerTest {
    @Autowired
    RegisterController registerController;

    @Mock
    UserManager userManager;

    @BeforeAll
    public void setup() {
        Mockito.when(userManager.addNewUser(anyString(), anyString())).thenAnswer(
                (Answer<User>) invocation -> User.builder()
                        .username(invocation.getArgument(0))
                        .password(invocation.getArgument(1))
                        .build()
        );
    }

    @Test
    public void GIVEN_goodInput_WHEN_register_THEN_returnCorrectRegisterResponse() {
        RegisterResponse response = registerController.register(RegisterRequest.builder()
                .username(TEST_USER_NAME_1)
                .password(TEST_PASSWORD_1)
                .build());
        Assertions.assertEquals(response.getUser().getUsername(), TEST_USER_NAME_1);
    }
}
