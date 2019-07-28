package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.models.Product;

public interface ProductsRepository extends JpaRepository<Product, String>{

}
