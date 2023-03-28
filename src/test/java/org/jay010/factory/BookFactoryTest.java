package org.jay010.factory;

import org.jay010.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookFactoryTest {

    private Book book2;

    @BeforeEach
    void setUp() {
        book2 = BookFactory.createBook("Game of Thrones", "Jon Snow", "Supernatural/Drama", 799.00);
    }

    @Test
    void testBookFactory(){
        System.out.println(book2.toString());
    }
}