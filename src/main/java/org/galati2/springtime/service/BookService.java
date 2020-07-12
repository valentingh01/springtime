package org.galati2.springtime.service;

import org.galati2.springtime.model.Book;
import org.galati2.springtime.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> getBooks() {
        List<Book> results = new ArrayList<>();
        Iterable<Book> books = repository.findAll();

        books.forEach(results::add);
//
//        for (Book book : books) {
//            results.add(book);
//        }
//
        return results;
    }

    public List<Book> getBooks(String title) {
        List<Book> results = new ArrayList<>();
        Iterable<Book> books = repository.findByTitleContaining(title);
        books.forEach(results::add);
        return results;
    }

    public List<Book> getBooks(String title, String subtitle) {
        List<Book> results = new ArrayList<>();
        Iterable<Book> books;
        if (title == null && subtitle == null){
            books = repository.findAll();
        } else if (title == null) {
            books = repository.findBySubtitleContaining(subtitle);
        } else if (subtitle == null) {
            books = repository.findByTitleContaining(title);
        } else {
            books = repository.findByTitleContainingAndSubtitleContaining(title, subtitle);
        }
        books.forEach(results::add);
        return results;
    }

    public Book getBook(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
