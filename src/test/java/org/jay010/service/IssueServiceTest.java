package org.jay010.service;

import org.jay010.entity.Issue;
import org.jay010.factory.IssueFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class IssueServiceTest {

    @Autowired
    private IssueService service = IssueService.getService();
    private Issue issue1, issue2, issue3;

    @BeforeEach
    void setUp() throws ParseException {
        String stringDate1_1 = "28/03/2023";
        Date date1_1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate1_1);

        String stringDate1_2 = "10/04/2023";
        Date date1_2 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate1_2);

        issue1 = IssueFactory.createIssue(0,1006,7, date1_1, 10, date1_2, 0);

        String stringDate2_1 = "4/03/2024";
        Date date2_1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate2_1);

        String stringDate2_2 = "13/03/2024";
        Date date2_2 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate2_2);

        issue2 = IssueFactory.createIssue(4,1001,8, date2_1, 5, date2_2, 0);

        String stringDate3_1 = "4/03/2024";
        Date date3_1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate3_1);

        String stringDate3_2 = "13/03/2024";
        Date date3_2 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate3_2);

        issue3 = IssueFactory.createIssue(5,11,200, date3_1, 5, date3_2, 0);
    }

    @Test
    void a_testAddIssue() {
        service.create(issue1);
        service.create(issue2);
    }

    @Test
    void b_testReadIssue() {
        System.out.println(service.read(5));
    }

    @Test
    void c_testUpdateIssue() {
        System.out.println(service.update(issue3));
    }

    @Test
    void f_testDeleteIssue() {
        System.out.println(service.delete(5));
    }

    @Test
    void d_testReadAllIssues() {
        service.create(issue1);
        service.create(issue2);

        List<Issue> issue = service.getAll();

        for(Issue issueList : issue)
            System.out.println(issueList.toString());
    }

    @Test
    void e_testCalculateFine() {
        // CalculateFine - true
            service.update(issue2, true);
            System.out.println("Calculate fine: " + issue2.getFine());
            assertEquals(issue2.getFine(), 25.0);

        // CalculateFine - false
            service.update(issue3, false);
            System.out.println("\n\nDon't calculate fine: " + issue3.getFine());
            assertEquals(issue3.getFine(), 0.0);
    }
}