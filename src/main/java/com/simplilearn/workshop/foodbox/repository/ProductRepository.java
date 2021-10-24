package com.simplilearn.workshop.foodbox.repository;

import com.simplilearn.workshop.foodbox.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    void deleteProductById(Long id);

    Optional<Product> findProductById(Long id);
}
