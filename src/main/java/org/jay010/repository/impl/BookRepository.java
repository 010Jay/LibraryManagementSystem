package org.jay010.repository.impl;

import org.jay010.entity.Book;
import org.jay010.repository.IBook;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            book = new Book.Builder()
                    .setBookID(result.getInt(1))
                    .setBookName(result.getString(2))
                    .setAuthor(result.getString(3))
                    .setGenre(result.getString(4))
                    .setPrice(result.getDouble(5))
                    .build();

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
    public int getSize() {
        db.openConnection();
        int size = 0;

        try{
            statement = db.connect.prepareStatement(sqlReadAll);
            result = statement.executeQuery();

            while(result.next()) {
                size++;
            }

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        }

        return size;
    }

    @Override
    public Book[] getAllBooks() {
        db.openConnection();
        int size = getSize();
        Book[] book = new Book[size];

        try{
            statement = db.connect.prepareStatement(sqlReadAll);
            result = statement.executeQuery();

            int i = 0;
            while(result.next()) {
                book[i] = new Book.Builder()
                        .setBookID(result.getInt(1))
                        .setBookName(result.getString(2))
                        .setAuthor(result.getString(3))
                        .setGenre(result.getString(4))
                        .setPrice(result.getDouble(5))
                        .build();

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

        return book;
    }
}
