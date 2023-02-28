package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.Locatie;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("intergrationtest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LocatieEndpointIT {

    @Autowired
    private TestRestTemplate restTemplate;

    private static long lastid = -1;

    @Test
    @Order(1)
    public void testPost() {

        // Given
        Locatie locatieToBePosted = new Locatie();

        // When
        ResponseEntity<Locatie> result = this.restTemplate.postForEntity("/locatie/voegLocatieToe", locatieToBePosted, Locatie.class);

        // Then
        assertEquals(200, result.getStatusCode().value());

        // Get en Delete testen hieronder nog toevoegen

    }

    @Test
    @Order(2)
    public void testGet() {

        // Given


        // When


        // Then

    }

    @Test
    @Order(3)
    public void testDelete() {

        // Given


        // When


        // Then

    }

}
