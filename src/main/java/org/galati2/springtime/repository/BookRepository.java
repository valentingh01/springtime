package org.galati2.springtime.repository;

import org.galati2.springtime.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends CrudRepository<Book, Integer> {
    Iterable<Book> findByTitleContaining(String title);
    Iterable<Book> findByTitleAndSubtitle(String title, String subtitle);
}
