package org.jay010.factory;

import org.jay010.entity.Book;

public class BookFactory {

    public static Book createBook(int bookID, String bookName, String author, String genre, double price) {
        return new Book.Builder()
                .setBookID(bookID)
                .setBookName(bookName)
                .setAuthor(author)
                .setGenre(genre)
                .setPrice(price)
                .build();
    }
}
