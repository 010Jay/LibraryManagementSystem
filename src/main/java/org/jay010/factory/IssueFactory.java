package org.jay010.factory;

import org.jay010.entity.Issue;

import java.util.Date;

public class IssueFactory {

    public static Issue createIssue(int userID, int bookID, Date issueDate, int period, Date returnDate, double fine) {
        return new Issue.Builder()
                .setUserID(userID)
                .setBookID(bookID)
                .setIssueDate(issueDate)
                .setPeriod(period)
                .setReturnDate(returnDate) //??
                .setFine(fine) //??
                .build();
    }
}
