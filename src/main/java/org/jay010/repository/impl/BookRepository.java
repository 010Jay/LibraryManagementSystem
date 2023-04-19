package org.jay010.repository.impl;

import org.jay010.entity.Book;
import org.jay010.factory.BookFactory;
import org.jay010.repository.IBook;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBook {

    private DatabaseConnection db = new DatabaseConnection();
    private PreparedStatement statement;
    private ResultSet result;

    public BookRepository() {}

    @Override
    public Book create(Book book) {
        db.openConnection();

        try {
            statement = db.connect.prepareStatement(sqlCreate);

            statement.setString(1, book.getBookName());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getGenre());
            statement.setDouble(4, book.getPrice());

            statement.executeUpdate();

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        } finally {

            try {
                if(statement != null)
                    statement.close();

                if(db.connect != null)
                    db.closeConnection();

            } catch (SQLException exception) {

                System.out.println("Error: " + exception.getMessage());
            }

        }

        return book;
    }

    @Override
    public Book read(Integer id) {
        db.openConnection();
        Book book = null;

        try{
            statement = db.connect.prepareStatement(sqlRead + id);
            result = statement.executeQuery();

            result.next();
            book = BookFactory.createBook(result.getInt(1), result.getString(2),
                    result.getString(3), result.getString(4), result.getDouble(5));

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        } finally {
            try{
                if(result != null)
                    result.close();

                if(statement != null)
                    statement.close();

                if(db.connect != null)
                    db.closeConnection();

            } catch (SQLException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        return book;
    }

    @Override
    public Book update(Book book) {
        db.openConnection();
        int id = book.getBookID();

        try{
            statement = db.connect.prepareStatement(sqlUpdate + id);

            statement.setString(1, book.getBookName());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getGenre());
            statement.setDouble(4, book.getPrice());

            statement.executeUpdate();

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        } finally {

            try {
                if(statement != null)
                    statement.close();

                if(db.connect != null)
                    db.closeConnection();

            } catch (SQLException exception) {

                System.out.println("Error: " + exception.getMessage());
            }

        }

        return book;
    }

    @Override
    public boolean delete(Integer id) {
        db.openConnection();

        try{
            statement = db.connect.prepareStatement(sqlDelete + id);
            int check = statement.executeUpdate();

            if(check > 0)
                return true;
            else
                return false;

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        }

        return false;
    }

    @Override
    public List<Book> getAll() {
        db.openConnection();
        List<Book> bookList = new ArrayList<>();

        try{
            statement = db.connect.prepareStatement(sqlReadAll);
            result = statement.executeQuery();

            int i = 0;
            while(result.next()) {
                Book book = BookFactory.createBook(result.getInt(1), result.getString(2),
                        result.getString(3), result.getString(4), result.getDouble(5));
                bookList.add(book);

                i++;
            }

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        } finally {
            try{
                if(result != null)
                    result.close();

                if(statement != null)
                    statement.close();

                if(db.connect != null)
                    db.closeConnection();

            } catch (SQLException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        return bookList;
    }
}
