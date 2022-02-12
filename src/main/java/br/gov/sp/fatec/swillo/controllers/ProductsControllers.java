package br.gov.sp.fatec.swillo.controllers;

import br.gov.sp.fatec.swillo.models.Products;
import br.gov.sp.fatec.swillo.services.ProductsService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsControllers {
    @Autowired
    private ProductsService productsService;

    @PostMapping("/products/create")
    public ResponseEntity<Products> createProduct(@RequestBody Products products){
        return ResponseEntity.ok(productsService.createProduct(products));
    }

    @GetMapping("products/list")
    public ResponseEntity<List<Products>> listAllProducts() {
        return ResponseEntity.ok(productsService.listAllProducts());
    }

}
