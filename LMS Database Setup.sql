
CREATE TABLE Book (
BookID int NOT NULL AUTO_INCREMENT,
Name varchar (25),
Author varchar (25),
Genre varchar (25),
Price double,

PRIMARY KEY (BookID)
);

CREATE TABLE User (
UserID int NOT NULL AUTO_INCREMENT,
FirstName varchar (25),
LastName varchar (25),
ContactNumber varchar (10),
EmailAddress varchar (35),
Username varchar (25),
Password varchar (25),
AdminPrivilege BOOLEAN,

PRIMARY KEY (UserID)
);

CREATE TABLE ISSUE (
IssueID int NOT NULL AUTO_INCREMENT,
UserID int,
BookID int,
IssueDate DATE,
Period int,
ReturnDate DATE,
Fine double,

PRIMARY KEY (IssueID),
FOREIGN KEY (BookID) REFERENCES Book (BookID),
FOREIGN KEY (UserID) REFERENCES User (UserID)
);

INSERT INTO User (
UserID,
FirstName,
LastName,
ContactNumber,
EmailAddress,
Username,
Password,
AdminPrivilege )

VALUES (
'1001', 
'Jon', 
'Snow', 
'0745038825', 
'jonsnow@gmail.com', 
'jonsnow01', 
'Password001', 
'1' );
