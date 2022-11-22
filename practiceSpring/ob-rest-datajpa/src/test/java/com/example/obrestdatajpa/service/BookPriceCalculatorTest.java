package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.entities.Books;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePrice() {
        Books book = new Books(1L, "Lord of the rings", "Auth", 1000, 49.99, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();
        double price = calculator.calculatePrice(book);
        assertTrue(price > 0);
        assertEquals(57.980000000000004, price);
    }
}