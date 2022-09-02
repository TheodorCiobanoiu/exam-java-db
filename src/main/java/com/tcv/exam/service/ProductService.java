package com.tcv.exam.service;

import com.tcv.exam.model.Product;
import com.tcv.exam.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product changePrice(Integer productId, Double newPrice){
        Optional<Product> optionalProduct = productRepository.findById(productId);
        optionalProduct.get().setPrice(newPrice);
        return productRepository.save(optionalProduct.get());
    }
}
