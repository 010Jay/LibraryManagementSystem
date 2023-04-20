package org.jay010.repository.impl;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class DatabaseConnection {

    private final String URL = "jdbc:mysql://localhost:3308/library";
    private final String username = "root";
    private  final String password = "";
    protected Connection connect;

    public void openConnection() {
        try {
            this.connect = DriverManager.getConnection(URL, username, password);

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if(this.connect != null)
                this.connect.close();

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        }
    }
}
