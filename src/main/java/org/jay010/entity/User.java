package org.jay010.entity;

public class User {

    private int userID;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String emailAddress;

    private String username;
    private String password;
    private boolean admin;

    public User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contactNumber = builder.contactNumber;
        this.emailAddress = builder.emailAddress;
        this.username = builder.username;
        this.password = builder.password;
        this.admin = false;
    }

    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userID=" + userID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber=" + contactNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }

    public static class Builder {

            private int userID;
            private String firstName;
            private String lastName;
            private String contactNumber;
            private String emailAddress;

            private String username;
            private String password;
            private boolean admin;

        public Builder setUserID(int userID) {
            this.userID = userID;
            return this;
        }

        public Builder setFirstName(String firstName) {
                this.firstName = firstName;
                return this;
            }

            public Builder setLastName(String lastName) {
                this.lastName = lastName;
                return this;
            }

            public Builder setContactNumber(String contactNumber) {
                this.contactNumber = contactNumber;
                return this;
            }

            public Builder setEmailAddress(String emailAddress) {
                this.emailAddress = emailAddress;
                return this;
            }

            public Builder setUsername(String username) {
                this.username = username;
                return this;
            }

            public Builder setPassword(String password) {
                this.password = password;
                return this;
            }

        public Builder setAdmin(boolean admin) {
            this.admin = admin;
            return this;
        }

        public User build() {
                return new User(this);
            }
        }
}
