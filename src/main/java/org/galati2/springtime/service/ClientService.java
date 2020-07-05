package org.galati2.springtime.service;

import org.galati2.springtime.model.Book;
import org.galati2.springtime.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientService {
//
//    @Autowired
//    private ClientRepository clientRepository;

    public void testClientservice(String clientName) {
        System.out.println("x");
//        Iterable<Book> clients = clientRepository.findAll();
//        Iterable<Book> clientsByName = clientRepository.findByNameContaining("Numele");
//        System.out.println("Testing client service with " + clientName);
    }
}
