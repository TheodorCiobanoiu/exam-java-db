package com.tcv.exam.controller;

import com.tcv.exam.exception.NoClientException;
import com.tcv.exam.model.Client;
import com.tcv.exam.model.Orders;
import com.tcv.exam.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("client")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("add")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @GetMapping("order-history/{clientId}")
    public List<Orders> seeOrderHistory(@PathVariable Integer clientId) throws NoClientException {
        return clientService.seeOrderHistory(clientId);
    }

    @GetMapping("total-spent/{clientId}")
    public Double getTotalSpent(@PathVariable Integer clientId) throws NoClientException {
        return clientService.totalSpent(clientId);
    }
}

