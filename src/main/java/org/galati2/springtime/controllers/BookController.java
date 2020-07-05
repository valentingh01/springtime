package org.galati2.springtime.controllers;

import org.galati2.springtime.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookController {

    @Autowired
    private BookService clientService;

    public void readBooks() {
        clientService.testBookservice();
    }
}
