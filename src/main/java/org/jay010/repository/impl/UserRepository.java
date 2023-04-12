package org.jay010.repository.impl;

import org.jay010.entity.User;
import org.jay010.repository.IUser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IUser {

    private DatabaseConnection db = new DatabaseConnection();
    private PreparedStatement statement;
    private ResultSet result;

    @Override
    public User create(User user) {
        db.openConnection();

        try {
            statement = db.connect.prepareStatement(sqlCreate);

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getContactNumber());
            statement.setString(4, user.getEmailAddress());
            statement.setString(5, user.getUsername());
            statement.setString(6, user.getPassword());
            statement.setBoolean(7, user.isAdmin());

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

        return user;
    }

    @Override
    public User read(Integer id) {
        db.openConnection();
        User user = null;

        try{
            statement = db.connect.prepareStatement(sqlRead + id);
            result = statement.executeQuery();

            result.next();
            user = new User.Builder()
                    .setFirstName(result.getString(1))
                    .setLastName(result.getString(2))
                    .setContactNumber(result.getString(3))
                    .setEmailAddress(result.getString(4))
                    .setUsername(result.getString(5))
                    .setPassword(result.getString(6))
                    .setAdmin(result.getBoolean(7))
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

        return user;
    }

    @Override
    public User update(User user) {
        db.openConnection();
        int id = user.getUserID();

        try{
            statement = db.connect.prepareStatement(sqlUpdate + id);

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getContactNumber());
            statement.setString(4, user.getEmailAddress());
            statement.setString(5, user.getUsername());
            statement.setString(6, user.getPassword());
            statement.setBoolean(7, user.isAdmin());

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

        return user;
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
    public User[] getAll() {
        db.openConnection();
        int size = getSize();
        User[] user = new User[size];

        try{
            statement = db.connect.prepareStatement(sqlReadAll);
            result = statement.executeQuery();

            int i = 0;
            while(result.next()) {
                user[i] = new User.Builder()
                        .setFirstName(result.getString(1))
                        .setLastName(result.getString(2))
                        .setContactNumber(result.getString(3))
                        .setEmailAddress(result.getString(4))
                        .setUsername(result.getString(5))
                        .setPassword(result.getString(6))
                        .setAdmin(result.getBoolean(7))
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

        return user;
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
}
