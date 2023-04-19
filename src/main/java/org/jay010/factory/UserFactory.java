package org.jay010.factory;

import org.jay010.entity.User;

public class UserFactory {

    public static User createUser(int userID, String firstName, String lastName, String contactNumber, String emailAddress, String username, String password, boolean admin){
        return new User.Builder()
                .setUserID(userID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContactNumber(contactNumber)
                .setEmailAddress(emailAddress)
                .setUsername(username)
                .setPassword(password)
                .setAdmin(admin)
                .build();
    }
}
