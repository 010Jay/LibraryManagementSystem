package org.jay010.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DatabaseConnectionTest {

    private DatabaseConnection db;

    @BeforeEach
    void setUp() {

        db = new DatabaseConnection();
    }

    @Test
    void a_testOpenConnection() {
        db.openConnection();

        try {
            boolean connectionStatus = db.connect.isClosed();

            if(!connectionStatus) {
                System.out.println("Connection is open.");
            }
            else
                System.out.println("Connection is close.");

            assertEquals(connectionStatus, false);

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        }
    }

    @Test
    void b_testCloseConnection() {
        db.closeConnection();

        try {
            boolean connectionStatus;

            if(db.connect != null) {
                connectionStatus = db.connect.isClosed();

                if(connectionStatus) {
                    System.out.println("Connection is close.");
                    assertEquals(connectionStatus, true);
                }
                else
                    System.out.println("Connection is open.");
            }
            else {
                System.out.println("db.connect is null");
                assertNull(db.connect);
            }

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        }
    }
}