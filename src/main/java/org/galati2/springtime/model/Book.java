package org.galati2.springtime.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    private int book_id;
    private String title;

    public int getId() {
        return book_id;
    }

    public Book setId(int id) {
        this.book_id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String name) {
        this.title = name;
        return this;
    }
}
