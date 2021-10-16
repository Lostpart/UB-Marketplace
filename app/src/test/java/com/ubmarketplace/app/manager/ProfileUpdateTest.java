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

import static com.ubmarketplace.app.Static.TEST_ALWAYS_WRONG_PASSWORD;
import static com.ubmarketplace.app.Static.TEST_PASSWORD_1;
import static com.ubmarketplace.app.Static.TEST_PASSWORD_2;
import static com.ubmarketplace.app.Static.TEST_USER_NAME_1;
import static com.ubmarketplace.app.Static.TEST_USER_NAME_2;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class ProfileUpdateTest {
    @Autowired
    UserManager usermanager;

    @BeforeAll
    static void setup(@Autowired UserRepository userRepository) {
        userRepository.insert(User.builder().username(TEST_USER_NAME_1).password(TEST_PASSWORD_1).displayname("123").build());
        userRepository.insert(User.builder().username(TEST_USER_NAME_2).password(TEST_PASSWORD_2).displayname("456").build());
    }


    @Test
    public void GIVEN_newpassword_When_updateUser_Then_match() {
        User updated = usermanager.updateUser(TEST_USER_NAME_1, "abc", "123");
        Assertions.assertTrue(updated.getPassword().equals("abc"));
    }

    @Test
    public void GIVEN_newDisplayname_When_updateUser_Then_match() {
        User updated = usermanager.updateUser(TEST_USER_NAME_1, TEST_USER_NAME_1, "12345678");
        Assertions.assertTrue(updated.getDisplayname().equals("12345678"));
    }

    @Test
    public void GIVEN_newpassword_And_displayname_When_updateUser_Then_match() {
        User updated = usermanager.updateUser(TEST_USER_NAME_1, "12345678", "abc");
        Assertions.assertTrue(updated.getDisplayname().equals("abc"));
        Assertions.assertTrue(updated.getPassword().equals("12345678"));
    }

    @Test
    public void GIVEN_emptyPassword_WHEN_updateUser_THEN_returnFalse() {
        Assertions.assertThrows(InvalidParameterException.class, () -> usermanager.updateUser(TEST_USER_NAME_1, "", "123"));
    }

    @Test
    public void GIVEN_emptydisplayname_WHEN_updateUser_THEN_returnFalse() {
        Assertions.assertThrows(InvalidParameterException.class, () -> usermanager.updateUser(TEST_USER_NAME_1, TEST_PASSWORD_1, ""));
    }

}

