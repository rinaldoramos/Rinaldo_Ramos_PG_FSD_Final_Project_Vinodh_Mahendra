package com.simplilearn.workshop.foodbox.service;

import com.simplilearn.workshop.foodbox.exception.ProductNotFoundException;
import com.simplilearn.workshop.foodbox.model.Product;
import com.simplilearn.workshop.foodbox.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findProductById(Long id) {
        return productRepository.findProductById(id).orElseThrow(() -> new ProductNotFoundException("Product with ID: " + id + " was not found"));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteProductById(id);
    }
}
