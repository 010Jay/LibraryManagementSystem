package org.jay010.service.impl;

import org.jay010.entity.Book;
import org.jay010.factory.BookFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class BookServiceTest {

    @Autowired
    private BookService service = BookService.getService();
    private Book book1, book2, book3;

    @BeforeEach
    void setUp() {
        book1 = BookFactory.createBook(0,"Game of Thrones",
                "Jon Snow", "Drama/Supernatural", 799.99);

        book2 = BookFactory.createBook(0,"A Song of Fire and Ice",
                "George R. R. Martin", "Supernatural", 899.99);

        book3 = BookFactory.createBook(11,"Animal Farm",
                "George Orwell", "Novella", 499.99);
    }

    @Test
    void a_testCreateBooks() {
        service.create(book1);
        service.create(book2);
    }

    @Test
    void b_testReadBook() {
        System.out.println(service.read(11));
    }

    @Test
    void c_testUpdateBook() {
        System.out.println(service.update(book3));
    }

    @Test
    void e_testDeleteBook() {
        System.out.println(service.delete(12));
    }

    @Test
    void d_testReadAllBooks() {
        /*service.create(book1);
        service.create(book2);*/
        List<Book> bookList = service.getAll();

        for(Book book : bookList)
            System.out.println(book.toString());
    }
}