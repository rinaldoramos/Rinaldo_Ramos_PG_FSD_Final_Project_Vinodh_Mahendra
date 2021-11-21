package com.simplilearn.workshop.foodbox.repository;

import com.simplilearn.workshop.foodbox.model.CustomerChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerChoiceRepository extends JpaRepository<CustomerChoice, Long> {

}
