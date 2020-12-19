package com.swillostore.swillostore.web;

import com.swillostore.swillostore.domain.Category;
import com.swillostore.swillostore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class CategoryResource {

    private final CategoryService categoryService;

    @Autowired
    public CategoryResource(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("category")
    public ResponseEntity<Category> save(@RequestBody Category category){
        return new ResponseEntity<Category>(categoryService.save(category), HttpStatus.CREATED);
    }
}
