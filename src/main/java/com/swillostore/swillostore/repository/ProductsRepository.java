package com.swillostore.swillostore.repository;

import com.swillostore.swillostore.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}
