package com.ubmarketplace.app.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class UserManagerTest {
    private static UserManager usermanager;

    @BeforeAll
    static void setup() {
        usermanager = new UserManager();
    }

    @Test
    public void GIVEN_goodInput_WHEN_loginVerification_THEN_returnTrue() {
        Assertions.assertTrue(usermanager.loginVerification("TestUser1", "GoodPassword"));
    }

    @Test
    public void GIVEN_goodInputWrongPassword_WHEN_loginVerification_THEN_returnFalse() {
        Assertions.assertFalse(usermanager.loginVerification("TestUser1", "WrongPassword"));
    }

    @Test
    public void GIVEN_emptyUsername_WHEN_loginVerification_THEN_returnFalse() {
        Assertions.assertThrows(InvalidParameterException.class, () -> usermanager.loginVerification("", "GoodPassword"));
    }

    @Test
    public void GIVEN_emptyPassword_WHEN_loginVerification_THEN_returnFalse() {
        Assertions.assertThrows(InvalidParameterException.class, () -> usermanager.loginVerification("TestUser1", ""));
    }
}
