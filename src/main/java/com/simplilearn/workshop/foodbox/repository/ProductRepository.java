package com.simplilearn.workshop.foodbox.repository;

import com.simplilearn.workshop.foodbox.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    void deleteProductById(Long id);

    Optional<Product> findProductById(Long id);

    Optional<Product> findProductByName(String name);
}
