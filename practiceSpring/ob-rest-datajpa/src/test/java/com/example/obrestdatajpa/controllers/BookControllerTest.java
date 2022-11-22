package com.example.obrestdatajpa.controllers;

import com.example.obrestdatajpa.entities.Books;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }


    @Test
    void hello() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/hola", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Hola Mundo que haces, pimpollo", response.getBody());
    }

    @Test
    void findAll() {
        ResponseEntity<Books[]> response = testRestTemplate.getForEntity("/api/books", Books[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());assertEquals(HttpStatus.OK, response.getStatusCode());

        List<Books> books = Arrays.asList(response.getBody());
        System.out.println(books.size());
    }

    @Test
    void findOneById() {
        ResponseEntity<Books> response = testRestTemplate.getForEntity("/api/books/1", Books.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void create() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "title": "Libro creado desde test",
                    "author": "TNTtato",
                    "pages": 999,
                    "price": 99.99,
                    "releaseDate": "1999-01-21",
                    "availableOnline": true
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Books> response = testRestTemplate.exchange("/api/books", HttpMethod.POST, request, Books.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {
    }
}