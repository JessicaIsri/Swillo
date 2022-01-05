package br.gov.sp.fatec.swillo.services;

import br.gov.sp.fatec.swillo.models.Products;

public interface ProductsService {
    public Products createProduct(Products products);
    public Products updateProduct(Products products);
    public void deleteProductById(Long id);
}
