package com.simplilearn.workshop.foodbox.resource;

import com.simplilearn.workshop.foodbox.model.CustomerChoice;
import com.simplilearn.workshop.foodbox.model.Product;
import com.simplilearn.workshop.foodbox.service.CustomerChoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/selection")
public class CustomerChoiceResource {

    private final CustomerChoiceService customerChoiceService;

    public CustomerChoiceResource(CustomerChoiceService customerChoiceService) {
        this.customerChoiceService = customerChoiceService;
    }

    // get all selection
    @GetMapping("/all")
    public ResponseEntity<List<CustomerChoice>> getAllSelection() {
        List<CustomerChoice> customerChoiceList = this.customerChoiceService.getAllSelection();
        return new ResponseEntity<>(customerChoiceList, HttpStatus.OK);
    }

    // add a selection
    @PostMapping("/add")
    public ResponseEntity<CustomerChoice> addSelection(@RequestBody Product product) {
        System.out.println("From the PostMapping method");
        CustomerChoice newSelection = this.customerChoiceService.addSelection(product);
        return new ResponseEntity<>(newSelection, HttpStatus.CREATED);
    }

    // delete a selection
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteSelection(@PathVariable("id") Long id) {
        this.customerChoiceService.deleteSelection(id);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    // delete all selection
    @DeleteMapping("/delete/all")
    @Transactional
    public ResponseEntity<?> deleteAllSelection() {
        this.customerChoiceService.deleteAllSelection();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
