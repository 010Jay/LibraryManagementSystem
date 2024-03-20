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
import org.springframework.web.util.UriComponentsBuilder;

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
        String stringDate1_1 = "4/03/2024";
        Date date1_1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate1_1);

        String stringDate1_2 = "13/03/2024";
        Date date1_2 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate1_2);

        issue1 = IssueFactory.createIssue(4,1010,9, date1_1, 5, date1_2, 0);

        String stringDate2_1 = "4/03/2024";
        Date date2_1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate2_1);

        String stringDate2_2 = "13/03/2024";
        Date date2_2 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate2_2);

        issue2 = IssueFactory.createIssue(5,1011,8, date2_1, 5, date2_2, 0);
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
    void g_testDeleteIssue() {
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

    @Test
    void e_testCalculateFine() {
        String URL = "/update";

        //Calculate fine - true
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL + URL)
                    .queryParam("calculateFine", true);

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> entity = new HttpEntity(issue1, headers);

            ResponseEntity<Issue> response = template.exchange(
                    builder.build().encode().toUri(),
                    HttpMethod.POST,
                    entity,
                    Issue.class);

            assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void f_testDoNotCalculateFine() {
        String URL = "/update";

        //Calculate fine - false
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL + URL)
                    .queryParam("calculateFine", false);

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> entity = new HttpEntity(issue2, headers);

            ResponseEntity<Issue> response = template.exchange(
                    builder.build().encode().toUri(),
                    HttpMethod.POST,
                    entity,
                    Issue.class);

            assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}