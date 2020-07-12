package org.galati2.springtime;

import org.galati2.springtime.controllers.BookController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringTimeCommandLineRunner implements CommandLineRunner {

    @Autowired
    private BookController controller;

    @Override
    public void run(String... args) throws Exception {
//        controller.getBooks();
    }
}
