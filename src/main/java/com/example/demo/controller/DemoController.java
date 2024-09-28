package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    UserRepository userRepository;

    /**
     * Create a new user
     * @param user
     * @return
     */
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {

        return userRepository.save(user);
    }

    /**
     * Get all users
     * @return
     */
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Get user by id
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    /**
     * Update user by id
     * @param id
     * @param userDetails
     * @return
     */
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    /**
     * Delete user by id
     * @param id
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}
