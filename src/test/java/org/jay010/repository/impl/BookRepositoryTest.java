package org.jay010.repository.impl;

import org.jay010.entity.Book;
import org.jay010.factory.BookFactory;
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
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepo;
    private Book book1, book2, book3;

    @BeforeEach
    void setUp() {
        book1 = BookFactory.createBook(0,"Game of Thrones",
                "Jon Snow", "Drama/Supernatural", 799.99);

        book2 = BookFactory.createBook(2,"A Song of Fire and Ice",
                "George R. R. Martin", "Supernatural", 899.99);

        book3 = BookFactory.createBook(0,"Animal Farm",
                "George Orwell", "Novella", 499.99);
    }

    @Test
    void a_testAddBook() {
        Book test = bookRepo.create(book1);
        assertNotNull(test);
    }

    @Test
    void b_testReadBook() {
        Book test = bookRepo.read(2);
        System.out.println(test.toString());
        assertNotNull(test);
    }

    @Test
    void c_testUpdateBook() {
        Book test = bookRepo.update(book2);
        assertNotNull(test);
    }

    @Test
    void e_testDeleteBook() {
        boolean result = bookRepo.delete(2);
        assertEquals(result, true);
    }

    @Test
    void d_testReadAllBooks() {
        /*bookRepo.create(book1);
        bookRepo.create(book2);
        bookRepo.create(book3);*/

        List<Book> book = bookRepo.getAll();

        for(Book bookList : book) {
            System.out.println(bookList.toString());
        }

    }
}