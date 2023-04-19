package org.jay010.repository.impl;

import org.jay010.entity.Issue;
import org.jay010.entity.User;
import org.jay010.factory.IssueFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {

    private Issue issue1, issue2, issue3;
    private  IssueRepository issueRepo = new IssueRepository();

    @BeforeEach
    void setUp() throws ParseException {
        String stringDate1_1 = "28/03/2023";
        java.util.Date date1_1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate1_1);

        String stringDate1_2 = "10/04/2023";
        Date date1_2 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate1_2);

        issue1 = IssueFactory.createIssue(0,1006,7, date1_1, 10, date1_2, 0);

        String stringDate2_1 = "15/04/2023";
        Date date2_1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate2_1);

        issue2 = IssueFactory.createIssue(0,10,154, date2_1, 5, null, 0);

        String stringDate3_1 = "28/03/2023";
        Date date3_1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate3_1);

        issue3 = IssueFactory.createIssue(0,11,200, date3_1, 10, null, 0);
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
}