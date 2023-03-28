package org.jay010.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    private User user1;

    @BeforeEach
    void setUp() {
        user1 = new User.Builder().setFirstName("Jon").setLastName("Snow")
                .setContactNumber("9885024103").setEmailAddress("jonsnow@gmail.com")
                .setUsername("jon010").setPassword("Password01").build();

    }

    @Test
    void testCreateUser() {
        System.out.println(user1.toString());
    }
}