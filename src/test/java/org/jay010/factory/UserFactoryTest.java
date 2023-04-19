package org.jay010.factory;

import org.jay010.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserFactoryTest {

    private User user1;

    @BeforeEach
    void setUp() {
        user1 = UserFactory.createUser(6, "Jon", "Snow", "9884521453", "jonsnow@gmail.com",
                "jonsnow010", "Password010", false);
    }

    @Test
    void testCreateUser(){
        System.out.println(user1.toString());
    }
}