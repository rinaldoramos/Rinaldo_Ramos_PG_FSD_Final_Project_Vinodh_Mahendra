package com.simplilearn.workshop.foodbox.service;


import com.simplilearn.workshop.foodbox.model.User;
import com.simplilearn.workshop.foodbox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // find user by username
    public User findUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    // add a new user
    public User addNewUser(User user) throws Exception {
        String username = user.getUsername();
        if (username != null && username != "") {
            User newUser = userRepository.findUserByUsername(username);
            if (newUser != null) {
                throw new Exception("User with username: " + username + " already exist");
            }
        } else {
            throw new Exception("Please enter a value for the username field ");
        }
        User newUser = userRepository.save(user);
        return newUser;
    }
}
