package br.gov.sp.fatec.swillo.services.impl;

import br.gov.sp.fatec.swillo.models.Products;
import br.gov.sp.fatec.swillo.repositories.ProductsRepository;
import br.gov.sp.fatec.swillo.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;
    public Products createProduct(Products products) {
        return productsRepository.save(products);
    }

    public Products findByName(String name) {
        return productsRepository.findByName(name);
    }

    public Products updateProduct(Products products) {
        return productsRepository.findById(products.getId()).map((oldProduct -> {
            Products productsUpdate = oldProduct;
            productsUpdate.setName(products.getName());
            productsUpdate.setCategory(products.getCategory());
            productsUpdate.setValue(products.getValue());
            return productsRepository.save(productsUpdate);
        })).orElse(null);
    }

    public void deleteProductById(Long id) {
        productsRepository.deleteById(id);
    }

}
