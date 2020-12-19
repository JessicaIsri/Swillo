package com.swillostore.swillostore.service;

import com.swillostore.swillostore.domain.Products;
import com.swillostore.swillostore.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }


    public Products save(Products products){
        return productsRepository.save(products);
    }
}
