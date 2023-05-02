package org.jay010.controller.impl;

import org.jay010.entity.User;
import org.jay010.factory.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    private User user1, user2;
    @Autowired
    private TestRestTemplate template;
    private final String BASE_URL = "http://localhost:8080/user";

    @BeforeEach
    void setUp() {
        user1 = UserFactory.createUser(0, "Jon", "Snow", "9884521453", "jonsnow@gmail.com",
                "jonsnow010", "Password010", false);

        user2 = UserFactory.createUser(1009, "Admin", "Test", "9884521453", "admin@gmail.com",
                "admin010", "Password0100", true);
    }

    @Test
    void a_testCreateUser() {
        String URL = BASE_URL + "/create";

        ResponseEntity<User> postResponse = template.postForEntity(URL, user1, User.class);
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void b_testReadUser() {
        String URL = BASE_URL + "/read/1009";

        ResponseEntity<User> getResponse = template.getForEntity(URL, User.class);
        User test = getResponse.getBody();
        System.out.println(test.toString());
        assertEquals(getResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void c_testUpdateUser() {
        String URL = BASE_URL + "/update";

        ResponseEntity<User> postResponse = template.postForEntity(URL, user2, User.class);
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void e_testDeleteUser() {
        String URL = BASE_URL + "/delete/" + user2.getUserID();
        template.delete(URL);
    }

    @Test
    void d_testReadAllUsers() {
        String URL = BASE_URL + "/getAll";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<String> response = template.exchange(URL, HttpMethod.GET, entity, String.class);

        System.out.println(response);
    }
}