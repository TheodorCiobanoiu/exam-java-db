package com.tcv.exam.controller;


import com.tcv.exam.exception.NoOwnerException;
import com.tcv.exam.exception.NoStoreException;
import com.tcv.exam.model.Product;
import com.tcv.exam.model.Store;
import com.tcv.exam.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("store")
public class StoreController {

    private final StoreService storeService;

    @PostMapping("add/{ownerId}")
    public Store addStore(@PathVariable Integer ownerId, @RequestBody Store store) throws NoOwnerException {
        return storeService.addStore(ownerId, store);
    }

    @PostMapping("add-product/{ownerId}/{storeId}")
    public Store addProduct(@PathVariable Integer ownerId, @PathVariable Integer storeId, @RequestBody Product product) throws NoStoreException, NoOwnerException {
        return storeService.addProduct(ownerId, storeId, product);
    }

}
