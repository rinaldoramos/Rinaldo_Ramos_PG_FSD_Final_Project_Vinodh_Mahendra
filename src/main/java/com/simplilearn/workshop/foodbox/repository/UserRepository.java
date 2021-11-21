package com.simplilearn.workshop.foodbox.repository;

import com.simplilearn.workshop.foodbox.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String user);
}
