package com.example.AddressBook;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createBuddyInfoTest() {

        // GIVEN
        HttpEntity<BuddyInfo> request = new HttpEntity<>(new BuddyInfo("Evan", "111 Bronson ave", "6139999999"));
        String resourceUrl = "http://localhost:" + port + "/buddyInfoes";

        // WHEN
        BuddyInfo buddyInfo = this.restTemplate.postForObject(resourceUrl, request, BuddyInfo.class);

        // THEN
        assertNotNull(buddyInfo);
        System.out.println(buddyInfo);
    }

    @Test
    public void createAddressBookTest() {

        // GIVEN
        HttpEntity<AddressBook> request = new HttpEntity<>(new AddressBook());
        String resourceUrl = "http://localhost:" + port + "/addressBook";

        // WHEN
        AddressBook addressBook = this.restTemplate.postForObject(resourceUrl, request, AddressBook.class);

        // THEN
        assertNotNull(addressBook);
        System.out.println(addressBook);
    }

    @Test
    public void putBuddyInfoInAddressBook() {

        // GIVEN

        // WHEN


        // THEN
    }

    @Test
    public void getAllBuddyInfoesInAddressBook() throws JsonProcessingException {

        // GIVEN
        String resourceUrl = "http://localhost:" + port + "/buddyInfoes";

        // WHEN
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);

        // THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        System.out.println(response);
    }

    @Test
    public void getOneBuddyInfoInAddressBook() {

        // GIVEN
        String resourceUrl = "http://localhost:" + port + "/buddyInfoes?x=1";

        // WHEN
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);

        // THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        System.out.println(response);
    }
}
