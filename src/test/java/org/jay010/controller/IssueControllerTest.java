package org.jay010.controller;

import org.jay010.entity.Issue;
import org.jay010.factory.IssueFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IssueControllerTest {

    private Issue issue1, issue2;
    @Autowired
    private TestRestTemplate template;
    private final String BASE_URL = "http://localhost:8080/issue";

    @BeforeEach
    void setUp() throws ParseException {
        String stringDate1_1 = "28/03/2023";
        Date date1_1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate1_1);

        String stringDate1_2 = "10/04/2023";
        Date date1_2 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate1_2);

        issue1 = IssueFactory.createIssue(0,1010,9, date1_1, 10, date1_2, 0);

        String stringDate2_1 = "5/04/2023";
        Date date2_1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate2_1);

        String stringDate2_2 = "10/04/2023";
        Date date2_2 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate2_2);

        issue2 = IssueFactory.createIssue(3,1011,8, date2_1, 5, date2_2, 0);
    }

    @Test
    void a_testCreateIssue() {
        String URL = BASE_URL + "/create";

        ResponseEntity<Issue> postResponse = template.postForEntity(URL, issue1, Issue.class);
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void b_testReadIssue() {
        String URL = BASE_URL + "/read/3";

        ResponseEntity<Issue> getResponse = template.getForEntity(URL, Issue.class);
        Issue test = getResponse.getBody();
        System.out.println(test.toString());
        assertEquals(getResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void c_testUpdateIssue() {
        String URL = BASE_URL + "/update";

        ResponseEntity<Issue> postResponse = template.postForEntity(URL, issue2, Issue.class);
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void e_testDeleteIssue() {
        String URL = BASE_URL + "/delete/" + issue2.getIssueID();
        template.delete(URL);
    }

    @Test
    void d_testReadAllIssues() {
        String URL = BASE_URL + "/getAll";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<String> response = template.exchange(URL, HttpMethod.GET, entity, String.class);

        System.out.println(response);
    }
}