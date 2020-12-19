package com.swillostore.swillostore.repository;

import com.swillostore.swillostore.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
