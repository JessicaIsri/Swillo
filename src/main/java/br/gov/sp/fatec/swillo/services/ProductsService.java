package br.gov.sp.fatec.swillo.services;

import br.gov.sp.fatec.swillo.models.Products;

import java.util.List;

public interface ProductsService {
    public Products createProduct(Products products);
    public Products updateProduct(Products products);
    public List<Products> listAllProducts();
    public void deleteProductById(Long id);
}
