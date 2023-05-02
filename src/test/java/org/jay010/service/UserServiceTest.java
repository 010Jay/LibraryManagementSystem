package org.jay010.service;

import org.jay010.entity.User;
import org.jay010.factory.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class UserServiceTest {

    @Autowired
    private UserService service = UserService.getService();
    private User user1, user2, user3;

    @BeforeEach
    void setUp() {
        user1 = UserFactory.createUser(0, "Jon", "Snow", "9884521453", "jonsnow@gmail.com",
                "jonsnow010", "Password010", false);

        user2 = UserFactory.createUser(0, "Admin", "Test", "9884521453", "admin@gmail.com",
                "admin010", "Password0100", true);

        user3 = UserFactory.createUser(0, "Elena", "Gilbert", "9884521453", "elenagilbert@gmail.com",
                "elena010", "Password00", false);
    }

    @Test
    void a_testAddUser() {
        service.create(user1);
        service.create(user2);
    }

    @Test
    void b_testReadUser() {
        System.out.println(service.read(1002));
    }

    @Test
    void c_testUpdateUser() {
        System.out.println(service.update(user3));
    }

    @Test
    void e_testDeleteUser() {
        System.out.println(service.delete(1004));
    }

    @Test
    void d_testReadAllUsers() {
        /*service.create(user1);
        service.create(user2);*/

        List<User> user = service.getAll();

        for(User userList : user)
            System.out.println(userList.toString());
    }
}