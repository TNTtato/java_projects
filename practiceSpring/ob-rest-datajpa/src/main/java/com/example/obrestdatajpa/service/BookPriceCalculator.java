package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.entities.Books;

public class BookPriceCalculator {

    public double calculatePrice(Books book) {
        double price = book.getPrice();

        if(book.getPages() > 300){
            price += 5;
        }

        price += 2.99;
        return price;
    }
}
