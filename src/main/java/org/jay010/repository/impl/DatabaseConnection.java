package org.jay010.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private final String URL = "jdbc:mysql://localhost:3306/library";
    private final String username = "root";
    private  final String password = "Admin-010";
    protected Connection connect;

    public DatabaseConnection() {}

    public void openConnection() {
        try {
            this.connect = DriverManager.getConnection(URL, username, password);

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        }
    }

    public void closeConnection() {
        try {
            this.connect.close();

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        }
    }
}
