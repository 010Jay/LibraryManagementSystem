package org.jay010.repository.impl;

import org.jay010.entity.User;
import org.jay010.factory.UserFactory;
import org.jay010.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    private DatabaseConnection db;
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
            user = UserFactory.createUser(result.getInt(1), result.getString(2), result.getString(3),
                    result.getString(4), result.getString(5), result.getString(6),
                    result.getString(7),result.getBoolean(8));

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

            return check > 0;

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        }

        return false;
    }

    @Override
    public List<User> getAll() {
        db.openConnection();
       List<User> userList = new ArrayList<>();

        try{
            statement = db.connect.prepareStatement(sqlReadAll);
            result = statement.executeQuery();

            int i = 0;
            while(result.next()) {
                User user = UserFactory.createUser(result.getInt(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7),result.getBoolean(8));
                userList.add(user);

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

        return userList;
    }
}
