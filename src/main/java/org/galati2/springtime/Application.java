package org.galati2.springtime;

import org.galati2.springtime.controllers.ClientsController;
import org.galati2.springtime.model.Book;
import org.galati2.springtime.repository.ClientRepository;
import org.galati2.springtime.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private ClientsController clientsController;

    @Bean
    public CommandLineRunner run(ClientRepository repository) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ClientService.class);
        context.refresh();

        return (args) -> {
            Iterable<Book> books = repository.findAll();
            for (Book b :
                    books) {
                System.out.println(b.getTitle());
            }
        };
    }

}
