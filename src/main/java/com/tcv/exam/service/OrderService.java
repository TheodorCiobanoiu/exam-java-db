package com.tcv.exam.service;

import com.tcv.exam.exception.NoClientException;
import com.tcv.exam.exception.NoStoreException;
import com.tcv.exam.model.Client;
import com.tcv.exam.model.Orders;
import com.tcv.exam.model.Product;
import com.tcv.exam.model.Store;
import com.tcv.exam.repository.ClientRepository;
import com.tcv.exam.repository.OrderRepository;
import com.tcv.exam.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final StoreRepository storeRepository;

    public Orders placeOrder(Integer clientId, Integer storeId, List<Product> products) throws NoClientException, NoStoreException {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        Optional<Store> optionalStore = storeRepository.findById(storeId);
        if(optionalClient.isEmpty())
            throw new NoClientException();
        if(optionalStore.isEmpty())
            throw new NoStoreException();

        return orderRepository.save(Orders.builder()
                .products(products)
                .store(optionalStore.get())
                .client(optionalClient.get())
                .build());
    }

}
