package org.jay010.repository.impl;

import org.jay010.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class BookRepositoryTest {

    private BookRepository bookRepo;
    private Book book1, book2, book3;

    @BeforeEach
    void setUp() {
        bookRepo = new BookRepository();

        book1 = new Book.Builder()
                .setBookName("Game of Thrones")
                .setAuthor("Jon Snow")
                .setGenre("Drama/Supernatural")
                .setPrice(799.99)
                .build();

        book2 = new Book.Builder()
                //.setBookID(2)
                .setBookName("A Song of Fire and Ice")
                .setAuthor("George R. R. Martin")
                .setGenre("Supernatural")
                .setPrice(899.99)
                .build();

        book3 = new Book.Builder()
                .setBookName("Animal Farm")
                .setAuthor("George Orwell")
                .setGenre("Novella")
                .setPrice(499.99)
                .build();
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

        Book[] book = bookRepo.getAllBooks();

        for(int i = 0; i < book.length; i++) {
            System.out.println(book[i].toString() + "\n");
        }
    }
}