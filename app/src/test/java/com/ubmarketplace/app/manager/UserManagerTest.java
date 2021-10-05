package com.ubmarketplace.app.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserManagerTest {
    @Autowired
    UserManager usermanager;

//    @Test
//    public void GIVEN_goodInput_WHEN_loginVerification_THEN_returnTrue() {
//        Assertions.assertTrue(usermanager.loginVerification("TestUser1", "GoodPassword"));
//    }
//
//    @Test
//    public void GIVEN_goodInputWrongPassword_WHEN_loginVerification_THEN_returnFalse() {
//        Assertions.assertFalse(usermanager.loginVerification("TestUser2", "WrongPassword"));
//    }
//
//    @Test
//    public void GIVEN_emptyUsername_WHEN_loginVerification_THEN_returnFalse() {
//        Assertions.assertThrows(InvalidParameterException.class, () -> usermanager.loginVerification("", "GoodPassword"));
//    }
//
//    @Test
//    public void GIVEN_emptyPassword_WHEN_loginVerification_THEN_returnFalse() {
//        Assertions.assertThrows(InvalidParameterException.class, () -> usermanager.loginVerification("TestUser1", ""));
//    }
}
