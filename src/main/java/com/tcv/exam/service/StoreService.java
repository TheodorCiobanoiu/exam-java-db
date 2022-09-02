package com.tcv.exam.service;


import com.tcv.exam.exception.NoOwnerException;
import com.tcv.exam.exception.NoStoreException;
import com.tcv.exam.model.Owner;
import com.tcv.exam.model.Product;
import com.tcv.exam.model.Store;
import com.tcv.exam.repository.OwnerRepository;
import com.tcv.exam.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final OwnerRepository ownerRepository;

    public Store addStore(Integer ownerId, Store store) throws NoOwnerException {
        if (ownerRepository.findById(ownerId).isPresent()) {
            return storeRepository.save(store);
        }
        else throw new NoOwnerException();
    }

    public Store addProduct(Integer ownerId, Integer storeId, Product product) throws NoOwnerException, NoStoreException {
        Optional<Store> optionalStore = storeRepository.findById(storeId);
        Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
        if(optionalOwner.isEmpty())
            throw new NoOwnerException();
        if(optionalStore.isEmpty())
            throw new NoStoreException();
        optionalStore.get().addProduct(product);
        return storeRepository.save(optionalStore.get());
    }


}
