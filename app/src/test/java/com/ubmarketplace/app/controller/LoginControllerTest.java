package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.dto.LoginRequest;
import com.ubmarketplace.app.dto.LoginResponse;
import com.ubmarketplace.app.model.User;
import com.ubmarketplace.app.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.security.InvalidParameterException;

import static com.ubmarketplace.app.TestStatic.TEST_ALWAYS_WRONG_PASSWORD;
import static com.ubmarketplace.app.TestStatic.TEST_PASSWORD_1;
import static com.ubmarketplace.app.TestStatic.TEST_PASSWORD_2;
import static com.ubmarketplace.app.TestStatic.TEST_USER_NAME_1;
import static com.ubmarketplace.app.TestStatic.TEST_USER_NAME_2;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class LoginControllerTest {
    @Autowired
    LoginController loginController;


    @BeforeAll
    static void setup(@Autowired UserRepository userRepository) {
        userRepository.insert(User.builder().username(TEST_USER_NAME_1).password(TEST_PASSWORD_1).build());
        userRepository.insert(User.builder().username(TEST_USER_NAME_2).password(TEST_PASSWORD_2).build());
    }

    @Test
    public void GIVEN_correctUsernamePassword_THEN_returnTrue(){
        LoginResponse response = loginController.login(new LoginRequest(TEST_USER_NAME_1, TEST_PASSWORD_1));
        Assertions.assertEquals(response.getUser().getUsername(), TEST_USER_NAME_1);
    }

    @Test
    public void GIVEN_correctUsernameWrongPassword_THEN_returnTrue(){
        Assertions.assertThrows(InvalidParameterException.class, () -> loginController.login(new LoginRequest(TEST_USER_NAME_1, TEST_ALWAYS_WRONG_PASSWORD)));
    }

    @Test
    public void GIVEN_WrongUsernameWrongPassword_THEN_returnTrue(){
        Assertions.assertThrows(InvalidParameterException.class, () -> loginController.login(new LoginRequest("", TEST_ALWAYS_WRONG_PASSWORD)));
    }



}
