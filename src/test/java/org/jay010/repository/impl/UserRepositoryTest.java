package org.jay010.repository.impl;

import org.jay010.entity.User;
import org.jay010.factory.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class UserRepositoryTest {

    private User user1, user2, user3;
    @Autowired
    private UserRepository userRepo = new UserRepository();

    @BeforeEach
    void setUp() {
        user1 = UserFactory.createUser(0, "Jon", "Snow", "9884521453", "jonsnow@gmail.com",
                "jonsnow010", "Password010", false);

        user2 = UserFactory.createUser(1002, "Admin", "Test", "9884521453", "admin@gmail.com",
                "admin010", "Password0100", true);

        user3 = UserFactory.createUser(0, "Elena", "Gilbert", "9884521453", "elenagilbert@gmail.com",
                "elena010", "Password00", false);
    }

    @Test
    void a_testAddUser() {
        User test = userRepo.create(user1);
        assertNotNull(test);
    }

    @Test
    void b_testReadUser() {
        User test = userRepo.read(1002);
        System.out.println(test.toString());
        assertNotNull(test);
    }

    @Test
    void c_testUpdateUser() {
        User test = userRepo.update(user2);
        assertNotNull(test);
    }

    @Test
    void e_testDeleteUser() {
        boolean result = userRepo.delete(1002);
        assertEquals(result, true);
    }

    @Test
    void d_testReadAllUsers() {
        /*userRepo.create(user1);
        userRepo.create(user2);
        userRepo.create(user3);*/

        List<User> user = userRepo.getAll();

        for(User userList : user) {
            System.out.println(userList.toString());
        }

    }
}