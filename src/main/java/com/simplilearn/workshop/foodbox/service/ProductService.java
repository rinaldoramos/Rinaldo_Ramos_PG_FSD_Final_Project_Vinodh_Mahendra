package com.simplilearn.workshop.foodbox.service;

import com.simplilearn.workshop.foodbox.exception.ProductNotFoundException;
import com.simplilearn.workshop.foodbox.model.Product;
import com.simplilearn.workshop.foodbox.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        /*Optional<Product> tempProduct = null;
        tempProduct = productRepository.findProductByName(product.getName());
        if (tempProduct == null) {
            return productRepository.save(product);
        }
        return  null;*/
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

    public Product findProductByName(String name) {
        return productRepository.findProductByName(name).orElseThrow(() -> new ProductNotFoundException("Product with name: " + name + " was not found"));
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
