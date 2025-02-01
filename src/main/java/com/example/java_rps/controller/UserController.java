package com.example.java_rps.controller;

import com.example.java_rps.repository.UserRepository;
import com.example.java_rps.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    public UserController(MyUserDetailsService userService) {
    }

//    @GetMapping("/")
//    public List<User> getAllUsers() {
//        return userService.getUsers();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getUserById(@PathVariable UUID id) {
//        return userService.getUserById(id);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateUser(@PathVariable UUID id, @RequestBody User user) {
//        return userService.updateUser(id, user);
//    }
//
//    @PostMapping("/")
//    public ResponseEntity<Object> createUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteUser(@PathVariable UUID id) {
//        return userService.deleteUser(id);
//    }
}