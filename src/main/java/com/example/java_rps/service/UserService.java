package com.example.java_rps.service;

import com.example.java_rps.model.MyUser;
import com.example.java_rps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> createUser(MyUser user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> getUserById(UUID id) {
        Optional<MyUser> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalUser);
    }

    public List<MyUser> getUsers() {
        return userRepository.findAll();
    }

//    public ResponseEntity<Object> updateUser(UUID id, User updateUser) {
//        Optional<User> optionalUser = userRepository.findById(id);
//
//        if (optionalUser.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        User existingUser = optionalUser.get();
//        existingUser.setEmail(updateUser.getEmail());
//        existingUser.setUsername(updateUser.getUsername());
//
//        return ResponseEntity.ok(existingUser);
//    }

    public ResponseEntity<Object> deleteUser(UUID id) {
        Optional<MyUser> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        userRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
