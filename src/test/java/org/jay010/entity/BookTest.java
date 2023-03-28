package org.jay010.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

    private Book book1;

    @BeforeEach
    void setUp() {
        book1 = new Book.Builder().setBookName("Game of Thrones").setAuthor("Jon Snow").setGenre("Supernatural/drama")
                .setPrice(799.00).build();
    }

    @Test
    void testBook() {
        System.out.println(book1.toString());
    }
}