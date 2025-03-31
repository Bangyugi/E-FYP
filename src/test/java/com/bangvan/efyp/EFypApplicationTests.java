package com.bangvan.efyp;

import com.bangvan.efyp.controller.AuthenticationController;
import com.bangvan.efyp.controller.UserController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EFypApplicationTests {

    @InjectMocks
    private AuthenticationController authenticationController;

    @InjectMocks
    private UserController userController;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(authenticationController);
        Assertions.assertNotNull(userController);
    }
}
