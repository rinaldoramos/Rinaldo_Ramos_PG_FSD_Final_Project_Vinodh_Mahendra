package com.simplilearn.workshop.foodbox.service;

import com.simplilearn.workshop.foodbox.model.CustomerChoice;
import com.simplilearn.workshop.foodbox.model.Product;
import com.simplilearn.workshop.foodbox.repository.CustomerChoiceRepository;
import com.simplilearn.workshop.foodbox.resource.ProductResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerChoiceService {

    private final CustomerChoiceRepository customerChoiceRepository;

    @Autowired
    public CustomerChoiceService(CustomerChoiceRepository customerChoiceRepository) {
        this.customerChoiceRepository = customerChoiceRepository;
    }

    // get all selection
    public List<CustomerChoice> getAllSelection(){
        return this.customerChoiceRepository.findAll();
    }

    // add a selection
    public CustomerChoice addSelection(Product product) {
        CustomerChoice temp = null;

        temp = new CustomerChoice(product.getId(), product.getImageUrl(), product.getName(), product.getDescription(),
                product.getPrice(), product.getCategory(), product.isState());

        return this.customerChoiceRepository.save(temp);
    }

    // delete a selection
    public void deleteSelection(Long id) {
        this.customerChoiceRepository.deleteById(id);
    }

    // truncate the table
    public void deleteAllSelection() {
        this.customerChoiceRepository.deleteAll();
    }
}
