package org.jay010.repository;

import org.jay010.entity.User;
import org.jay010.generic.IGenericCRUD;

public interface IUserRepository extends IGenericCRUD<User, Integer> {

    String sqlCreate = "INSERT INTO user (FirstName, LastName, ContactNumber, EmailAddress, " +
                        "Username, Password, AdminPrivilege) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String sqlRead = "SELECT * FROM user WHERE UserID = ";
    String sqlUpdate = "UPDATE user SET FirstName = ?, LastName = ?, ContactNumber = ?, EmailAddress = ?, " +
                        "Username = ?, Password = ?, AdminPrivilege = ? WHERE UserID = ";
    String sqlDelete = "DELETE FROM user WHERE UserID = ";
    String sqlReadAll = "SELECT * FROM user";
}
