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
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        Book result = bookService.getBook(id);
        if (result == null) {
            model.addAttribute("books", bookService.getBooks());
            return "booksList";
        }
        model.addAttribute("book", result);
        return "addBook";
    }

    @PostMapping("/books/{id}")
    public String changeBook(@PathVariable Long id, @ModelAttribute("book") Book book, Model model) {
        book.setBook_id(id);
        bookService.saveBook(book);
        model.addAttribute("books", bookService.getBooks());
        return "booksList";
    }
    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable Long id, Model model) {
        bookService.deleteBook(id);
        model.addAttribute("books", bookService.getBooks());
        return "booksList";
    }

    @PostMapping("/books")
    public String addBook(@ModelAttribute("book") Book book, Model model) {
        bookService.saveBook(book);
        model.addAttribute("books", bookService.getBooks());
        return "booksList";
    }
}
