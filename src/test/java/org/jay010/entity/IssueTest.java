package org.jay010.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class IssueTest {

    private Issue issue1, issue2;

    @BeforeEach
    void setUp() throws ParseException {
        String stringDate1 = "28/03/2023";
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate1);

        String stringDate2 = "10/04/2023";
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate2);

        String stringDate3 = "31/03/2023";
        Date date3 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate3);

        issue1 = new Issue.Builder()
                .setBookID(7)
                .setUserID(10)
                .setIssueDate(date1)
                .setPeriod(10)
                .setReturnDate(date2)
                .build();

        issue2 = new Issue.Builder()
                .setBookID(9)
                .setUserID(11)
                .setIssueDate(date1)
                .setPeriod(10)
                .setReturnDate(date3)
                .build();
    }

    @Test
    void testCreateIssue(){
        System.out.println(issue1.toString());
    }

    @Test
    void testDaysOverdue(){

        // Days extending the period (Overdue)
            int days1 = issue1.numberOfDaysOverdue();
            System.out.println("Days Overdue: " + days1);

        // Days not extending the period (Not overdue)
            int days2 = issue2.numberOfDaysOverdue();
            System.out.println("Days Overdue: " + days2);

    }

    @Test
    void testCalculateFine(){
        issue1.calculateFine();
        double fine1 = issue1.getFine();
        System.out.println("Fine 1: " + fine1);
        assertEquals(fine1, 20.0);

        issue2.calculateFine();
        double fine2 = issue2.getFine();
        System.out.println("\nFine 2: " + fine2);
        assertEquals(fine2, 0.0);
    }
}