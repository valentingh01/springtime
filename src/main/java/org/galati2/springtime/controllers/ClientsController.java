package org.galati2.springtime.controllers;

import org.galati2.springtime.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientsController {

    @Autowired
    private ClientService clientService;

    public String GetClients() {
        String client = "Acest minunat client";
        clientService.testClientservice(client);
        return client;
    }
}
