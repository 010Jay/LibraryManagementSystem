package org.jay010.factory;

import org.jay010.entity.Issue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;



class IssueFactoryTest {

    private Issue issue1;

    @BeforeEach
    void setUp() throws ParseException {
        String stringDate1 = "28/03/2023";
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate1);

        String stringDate2 = "10/04/2023";
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate2);

        issue1 = IssueFactory.createIssue(0,7,101, date1, 10, date2, 0);
    }

    @Test
    void testCreateIssue(){
        System.out.println(issue1.toString());
    }
}