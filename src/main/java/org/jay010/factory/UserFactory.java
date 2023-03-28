package org.jay010.factory;

import org.jay010.entity.User;

public class UserFactory {

    public static User createUser(String firstName, String lastName, String contactNumber, String emailAddress, String username, String password){
        return new User.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContactNumber(contactNumber)
                .setEmailAddress(emailAddress)
                .setUsername(username)
                .setPassword(password)
                .build();
    }
}