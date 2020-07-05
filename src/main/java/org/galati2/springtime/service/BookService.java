package org.galati2.springtime.service;

import org.galati2.springtime.model.Book;
import org.galati2.springtime.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    @Autowired
    private BookRepository repository;

    public void testBookservice() {
        Iterable<Book> books = repository.findAll();
        for (Book b :
                books) {
            System.out.println(b.getTitle());
        }
    }
}
