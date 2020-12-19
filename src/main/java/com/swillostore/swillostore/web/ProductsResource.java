package com.swillostore.swillostore.web;

import com.swillostore.swillostore.domain.Products;
import com.swillostore.swillostore.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class ProductsResource {

    private final ProductsService productsService;

    @Autowired
    public ProductsResource(ProductsService productsService){
        this.productsService = productsService;
    }

    @PostMapping("products")
    public ResponseEntity<Products> save(@RequestBody Products products){
        return new ResponseEntity<Products>(productsService.save(products), HttpStatus.OK);
    }


}
