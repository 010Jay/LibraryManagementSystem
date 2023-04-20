package org.jay010.repository;

import org.jay010.entity.Issue;

public interface IIssueRepository extends IRepository<Issue, Integer> {

    String sqlCreate = "INSERT INTO issue (UserID, BookID, IssueDate, " +
            "Period, ReturnDate, Fine) VALUES (?, ?, ?, ?, ?, ?)";
    String sqlRead = "SELECT * FROM issue WHERE IssueID = ";
    String sqlUpdate = "UPDATE issue SET UserID = ?, BookID = ?, IssueDate = ?, " +
            "Period = ?, ReturnDate = ?, Fine = ? WHERE IssueID = ";
    String sqlDelete = "DELETE FROM issue WHERE IssueID = ";
    String sqlReadAll = "SELECT * FROM issue";
}
