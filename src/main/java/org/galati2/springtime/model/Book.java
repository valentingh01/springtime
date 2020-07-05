package org.galati2.springtime.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private int book_id;
    private String name;
    private String address;

    public int getId() {
        return book_id;
    }

    public Book setId(int id) {
        this.book_id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Book setAddress(String address) {
        this.address = address;
        return this;
    }
}
