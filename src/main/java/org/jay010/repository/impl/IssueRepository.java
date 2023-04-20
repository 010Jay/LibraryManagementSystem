package org.jay010.repository.impl;

import org.jay010.entity.Issue;
import org.jay010.factory.IssueFactory;
import org.jay010.repository.IIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueRepository implements IIssueRepository {

    @Autowired
    private DatabaseConnection db;
    private PreparedStatement statement;
    private ResultSet result;

    @Override
    public Issue create(Issue issue) {
        db.openConnection();

        try {
            statement = db.connect.prepareStatement(sqlCreate);

            statement.setInt(1, issue.getUserID());
            statement.setInt(2, issue.getBookID());
            statement.setDate(3, new java.sql.Date(issue.getIssueDate().getTime()));
            statement.setInt(4, issue.getPeriod());
            statement.setDate(5,  new java.sql.Date(issue.getReturnDate().getTime()));
            statement.setDouble(6, issue.getFine());

            statement.executeUpdate();

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        } finally {

            try {
                if(statement != null)
                    statement.close();

                if(db.connect != null)
                    db.closeConnection();

            } catch (SQLException exception) {

                System.out.println("Error: " + exception.getMessage());
            }

        }

        return issue;
    }

    @Override
    public Issue read(Integer id) {
        db.openConnection();
        Issue issue = null;

        try{
            statement = db.connect.prepareStatement(sqlRead + id);
            result = statement.executeQuery();

            result.next();
            issue = IssueFactory.createIssue(result.getInt(1), result.getInt(2), result.getInt(3),
                    result.getDate(4), result.getInt(5), result.getDate(6),
                    result.getDouble(7));

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        } finally {
            try{
                if(result != null)
                    result.close();

                if(statement != null)
                    statement.close();

                if(db.connect != null)
                    db.closeConnection();

            } catch (SQLException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        return issue;
    }

    @Override
    public Issue update(Issue issue) {
        db.openConnection();
        int id = issue.getIssueID();

        try{
            statement = db.connect.prepareStatement(sqlUpdate + id);

            statement.setInt(1, issue.getUserID());
            statement.setInt(2, issue.getBookID());
            statement.setDate(3, new java.sql.Date(issue.getIssueDate().getTime()));
            statement.setInt(4, issue.getPeriod());
            statement.setDate(5,  new java.sql.Date(issue.getReturnDate().getTime()));
            statement.setDouble(6, issue.getFine());

            statement.executeUpdate();

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        } finally {

            try {
                if(statement != null)
                    statement.close();

                if(db.connect != null)
                    db.closeConnection();

            } catch (SQLException exception) {

                System.out.println("Error: " + exception.getMessage());
            }

        }

        return issue;
    }

    @Override
    public boolean delete(Integer id) {
        db.openConnection();

        try{
            statement = db.connect.prepareStatement(sqlDelete + id);
            int check = statement.executeUpdate();

            return check > 0;

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        }

        return false;
    }

    @Override
    public List<Issue> getAll() {
        db.openConnection();
        List<Issue> issueList = new ArrayList<>();

        try{
            statement = db.connect.prepareStatement(sqlReadAll);
            result = statement.executeQuery();

            int i = 0;
            while(result.next()) {
                Issue issue = IssueFactory.createIssue(result.getInt(1), result.getInt(2), result.getInt(3),
                        result.getDate(4), result.getInt(5), result.getDate(6),
                        result.getDouble(7));
                issueList.add(issue);

                i++;
            }

        } catch (SQLException exception) {

            System.out.println("Error: " + exception.getMessage());
        } finally {
            try{
                if(result != null)
                    result.close();

                if(statement != null)
                    statement.close();

                if(db.connect != null)
                    db.closeConnection();

            } catch (SQLException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        return issueList;
    }
}
