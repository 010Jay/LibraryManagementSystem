package org.jay010.repository;

import org.jay010.entity.User;

public interface IUser extends IRepository<User, Integer> {

    String sqlCreate = "INSERT INTO user (FirstName, LastName, ContactNumber, EmailAddress, " +
                        "Username, Password, Admin) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String sqlRead = "SELECT * FROM user WHERE UserID = ";
    String sqlUpdate = "UPDATE user SET FirstName = ?, LastName = ?, ContactNumber = ?, EmailAddress = ?, " +
                        "Username = ?, Password = ?, Admin = ? WHERE UserID = ";
    String sqlDelete = "DELETE FROM user WHERE UserID = ";
    String sqlReadAll = "SELECT * FROM user";
}
