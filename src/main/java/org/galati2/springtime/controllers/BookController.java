package org.galati2.springtime.controllers;

import org.galati2.springtime.model.Book;
import org.galati2.springtime.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "subtitle", required = false) String subtitle
    ) {
        List<Book> books = bookService.getBooks(title, subtitle);
        return books;
    }

    @GetMapping("/books/title/{title}/subtitle/{subtitle}")
    public List<Book> getBooksByPath(@PathVariable String title, @PathVariable String subtitle) {
        List<Book> books = bookService.getBooks();
        return books;
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {
        Book result = bookService.getBook(id);
//        return result == null
//                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
//                : new ResponseEntity<>(result, HttpStatus.OK);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
