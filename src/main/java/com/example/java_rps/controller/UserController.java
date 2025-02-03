package com.example.java_rps.controller;

import com.example.java_rps.model.MyUser;
import com.example.java_rps.repository.UserRepository;
import com.example.java_rps.service.MyUserDetailsService;
import com.example.java_rps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserController(UserService userService) {
    }

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public MyUser register(@RequestBody MyUser user) {

        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody MyUser user) {
        return userService.verify(user);
    }

//    @GetMapping("/")
//    public List<User> getAllUsers() {
//        return userService.getUsers();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getUserById(@PathVariable int id) {
//        return userService.getUserById(id);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateUser(@PathVariable int id, @RequestBody User user) {
//        return userService.updateUser(id, user);
//    }
//
//    @PostMapping("/")
//    public ResponseEntity<Object> createUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
//        return userService.deleteUser(id);
//    }
}