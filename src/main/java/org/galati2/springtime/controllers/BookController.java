package org.galati2.springtime.controllers;

import org.galati2.springtime.model.Book;
import org.galati2.springtime.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getBooks(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "subtitle", required = false) String subtitle,
            Model userInterfaceModel // ViewModel
    ) {
        List<Book> books = bookService.getBooks(title, subtitle);
        userInterfaceModel.addAttribute("books", books);
        return "booksList";
    }

    @GetMapping("/books/add")
    public String addBook() {
        return "addBook";
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {
        Book result = bookService.getBook(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> changeBook(@PathVariable int id, @RequestBody Book book) {
        book.setBook_id(id);
        Book result = bookService.saveBook(book);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/books")
    public Book addBook(@Valid Book book, BindingResult result, Model model) {
        return bookService.saveBook(book);
    }

    @GetMapping("/books/title/{title}/subtitle/{subtitle}")
    public List<Book> getBooksByPath(@PathVariable String title, @PathVariable String subtitle) {
        List<Book> books = bookService.getBooks();
        return books;
    }
}
