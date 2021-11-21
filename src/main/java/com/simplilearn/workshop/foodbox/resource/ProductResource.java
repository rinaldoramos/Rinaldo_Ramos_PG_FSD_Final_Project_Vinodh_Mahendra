package com.simplilearn.workshop.foodbox.resource;

import com.simplilearn.workshop.foodbox.model.Product;
import com.simplilearn.workshop.foodbox.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/findProduct/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name) {
        Product product = productService.findProductByName(name);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
       /* Product newProduct = productService.addProduct(product);
        if (newProduct == null) {
            return new ResponseEntity<>(newProduct, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);*/

        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        Product product = productService.findProductById(id);

        if (product != null) {
            System.out.println(product);
            productService.deleteProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
