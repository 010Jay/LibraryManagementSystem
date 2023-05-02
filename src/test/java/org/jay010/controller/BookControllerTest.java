package org.jay010.controller;

import org.jay010.entity.Book;
import org.jay010.factory.BookFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private Book book1, book2, test;
    @Autowired
    private TestRestTemplate template;
    private final String BASE_URL = "http://localhost:8080/book";

    @BeforeEach
    void setUp() {
        book1 = BookFactory.createBook(0,"Game of Thrones",
                "Jon Snow", "Drama/Supernatural", 799.99);

        book2 = BookFactory.createBook(15,"A Song of Fire and Ice",
                "George R. R. Martin", "Supernatural", 899.99);

    }

    @Test
    void a_testCreateBooks() {
        String URL = BASE_URL + "/create";

        ResponseEntity<Book> postResponse = template.postForEntity(URL, book1, Book.class);
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void b_testReadBook() {
        String URL = BASE_URL + "/read/15";

        ResponseEntity<Book> getResponse = template.getForEntity(URL, Book.class);
        test = getResponse.getBody();
        System.out.println(test.toString());
        assertEquals(getResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void c_testUpdateBook() {
        String URL = BASE_URL + "/update";

        ResponseEntity<Book> postResponse = template.postForEntity(URL, book2, Book.class);
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void e_testDeleteBook() {
        String URL = BASE_URL + "/delete/" + book2.getBookID();
        template.delete(URL);
    }

    @Test
    void d_testReadAllBooks() {
        String URL = BASE_URL + "/getAll";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<String> response = template.exchange(URL, HttpMethod.GET, entity, String.class);

        System.out.println(response);
    }
}