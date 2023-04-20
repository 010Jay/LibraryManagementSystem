package org.jay010.repository;

import org.jay010.entity.Book;

public interface IBookRepository extends IRepository<Book, Integer> {

    String sqlCreate = "INSERT INTO book (Name, Author, Genre, Price) VALUES (?, ?, ?, ?)";
    String sqlRead = "SELECT * FROM book WHERE BookID = ";
    String sqlUpdate = "UPDATE book SET Name = ?, Author = ?, Genre = ?, Price = ? WHERE BookID = ";
    String sqlDelete = "DELETE FROM book WHERE BookID = ";
    String sqlReadAll = "SELECT * FROM book";
}
