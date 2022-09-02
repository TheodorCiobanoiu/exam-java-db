package com.tcv.exam.controller;

import com.tcv.exam.model.Product;
import com.tcv.exam.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("add")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @PostMapping("change-price/{productId}/{newPrice}")
    public Product changePrice(@PathVariable Integer productId, @PathVariable Double newPrice){
        return productService.changePrice(productId, newPrice);
    }
}
