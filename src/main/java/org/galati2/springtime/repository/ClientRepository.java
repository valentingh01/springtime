package org.galati2.springtime.repository;

import org.galati2.springtime.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClientRepository extends CrudRepository<Book, Integer> {
    Iterable<Book> findByNameContaining(String name);
}
