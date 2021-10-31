package com.ubmarketplace.app.manager;

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
import static com.ubmarketplace.app.TestStatic.TEST_PASSWORD_3;
import static com.ubmarketplace.app.TestStatic.TEST_USER_NAME_1;
import static com.ubmarketplace.app.TestStatic.TEST_USER_NAME_2;
import static com.ubmarketplace.app.TestStatic.TEST_USER_NAME_3;
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class UserManagerTest {
    @Autowired
    UserManager usermanager;

    @BeforeAll
    static void setup(@Autowired UserRepository userRepository) {
        userRepository.insert(User.builder().username(TEST_USER_NAME_1).password(TEST_PASSWORD_1).build());
        userRepository.insert(User.builder().username(TEST_USER_NAME_2).password(TEST_PASSWORD_2).build());
    }

    @Test
    public void GIVEN_goodInput_WHEN_addNewUser_THEN_returnTrue(@Autowired UserRepository userRepository){
        User user = User.builder().username(TEST_USER_NAME_3).password(TEST_PASSWORD_3).build();
        usermanager.addNewUser(TEST_USER_NAME_3, TEST_PASSWORD_3, "DisplayName");
        Assertions.assertEquals(userRepository.findById(TEST_USER_NAME_3).getUsername(), user.getUsername());
    }

    @Test
    public void GIVEN_goodInput_WHEN_loginVerification_THEN_returnTrue() {
        Assertions.assertTrue(usermanager.loginVerification(TEST_USER_NAME_1, TEST_PASSWORD_1));
    }

    @Test
    public void GIVEN_goodInputWrongPassword_WHEN_loginVerification_THEN_returnFalse() {
        Assertions.assertFalse(usermanager.loginVerification(TEST_USER_NAME_2, TEST_ALWAYS_WRONG_PASSWORD));
    }

    @Test
    public void GIVEN_emptyUsername_WHEN_loginVerification_THEN_returnFalse() {
        Assertions.assertThrows(InvalidParameterException.class, () -> usermanager.loginVerification("", TEST_PASSWORD_1));
    }

    @Test
    public void GIVEN_emptyPassword_WHEN_loginVerification_THEN_returnFalse() {
        Assertions.assertThrows(InvalidParameterException.class, () -> usermanager.loginVerification(TEST_USER_NAME_1, ""));
    }
}
