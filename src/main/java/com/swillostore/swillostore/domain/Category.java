package com.swillostore.swillostore.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true
    )

    private final List<Products> products = new ArrayList<>();

    public void addProduct(Products product){
        products.add(product);
        product.setCategory(this);
    }

    public void removeProduct(Products product){
        products.remove(product);
        product.setCategory(null);
    }
}
