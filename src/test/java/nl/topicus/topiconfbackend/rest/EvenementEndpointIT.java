package nl.topicus.topiconfbackend.rest;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("intergrationtest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class EvenementEndpointIT {

    @Autowired
    private TestRestTemplate restTemplate;

    private static long lastID = -1;

    @Test
    @Order(1)
    public void testPost() {

        // To be programmed

        // Given

        // When

        // Then

    }

    @Test
    @Order(2)
    public void testGet() {

        // To be programmed

        // Given

        // When

        // Then

    }

    @Test
    @Order(3)
    public void testDelete() {

        // To be programmed

        // Given

        // When

        // Then

    }
}
