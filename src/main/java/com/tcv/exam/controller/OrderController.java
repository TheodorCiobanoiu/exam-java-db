package com.tcv.exam.controller;


import com.tcv.exam.exception.NoClientException;
import com.tcv.exam.exception.NoStoreException;
import com.tcv.exam.model.Orders;
import com.tcv.exam.model.Product;
import com.tcv.exam.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;


    @PostMapping("{clientId}/{storeId}")
    public Orders placeOrder(@PathVariable Integer clientId, @PathVariable Integer storeId, @RequestBody List<Product> products) throws NoClientException, NoStoreException {
        return orderService.placeOrder(clientId, storeId, products);
    }
}
