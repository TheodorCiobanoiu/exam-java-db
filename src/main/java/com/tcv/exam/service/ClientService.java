package com.tcv.exam.service;

import com.tcv.exam.exception.NoClientException;
import com.tcv.exam.model.Client;
import com.tcv.exam.model.Orders;
import com.tcv.exam.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client addClient(Client client){
        return clientRepository.save(client);
    }

    public List<Orders> seeOrderHistory(Integer clientId) throws NoClientException {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if(optionalClient.isPresent()){
            return optionalClient.get().getOrders();
        }
        else throw new NoClientException();
    }

    public Double totalSpent(Integer clientId) throws NoClientException {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if(optionalClient.isPresent()){
            return optionalClient.get().getOrders().stream()
                    .map(Orders::getOrderCost).reduce(0.00, Double::sum);
        }
        else throw new NoClientException();
    }

}
