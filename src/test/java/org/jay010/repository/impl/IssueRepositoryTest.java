package org.jay010.repository.impl;

import org.jay010.entity.Issue;
import org.jay010.factory.IssueFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {

    private Issue issue1, issue2, issue3;
    private  IssueRepository issueRepo = new IssueRepository();

    @BeforeEach
    void setUp() throws ParseException {
        String stringDate1_1 = "28/03/2023";
        Date date1_1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate1_1);

        String stringDate1_2 = "10/04/2023";
        Date date1_2 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate1_2);

        issue1 = IssueFactory.createIssue(0,1006,7, date1_1, 10, date1_2, 0);

        String stringDate2_1 = "5/04/2023";
        Date date2_1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate2_1);

        String stringDate2_2 = "10/04/2023";
        Date date2_2 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate2_2);

        issue2 = IssueFactory.createIssue(1,1001,8, date2_1, 5, date2_2, 0);

        String stringDate3_1 = "28/03/2023";
        Date date3_1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate3_1);

        String stringDate3_2 = "10/04/2023";
        Date date3_2 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate3_2);

        issue3 = IssueFactory.createIssue(0,11,200, date3_1, 10, date3_2, 0);
    }

    @Test
    void a_testAddIssue() {
        issue1.calculateFine();
        Issue test = issueRepo.create(issue1);
        assertNotNull(test);
    }

    @Test
    void b_testReadIssue() {
        Issue test = issueRepo.read(2);
        System.out.println(test.toString());
        assertNotNull(test);
    }

    @Test
    void c_testUpdateIssue() {
        Issue test = issueRepo.update(issue2);
        assertNotNull(test);
    }

    @Test
    void e_testDeleteIssue() {
        boolean result = issueRepo.delete(1);
        assertEquals(result, true);
    }

    @Test
    void d_testReadAllIssues() {
        issueRepo.create(issue1);
        issueRepo.create(issue2);
        issueRepo.create(issue3);

        List<Issue> issue = issueRepo.getAll();

        for(Issue issueList : issue) {
            System.out.println(issueList.toString());
        }

    }
}