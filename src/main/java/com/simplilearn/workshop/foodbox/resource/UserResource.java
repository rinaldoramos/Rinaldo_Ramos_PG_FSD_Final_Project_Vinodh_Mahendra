package com.simplilearn.workshop.foodbox.resource;

import com.simplilearn.workshop.foodbox.model.User;
import com.simplilearn.workshop.foodbox.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserResource {

    private final UserService userService;


    public UserResource(UserService userService) {
        this.userService = userService;
    }

    //get all users
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // add a new user
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) throws Exception {
        User newUser = userService.addNewUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
