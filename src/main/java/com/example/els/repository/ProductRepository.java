package com.example.els.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.els.global.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Long> {
}
