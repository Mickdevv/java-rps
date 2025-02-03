package com.example.java_rps.service;

import com.example.java_rps.model.MyUser;
import org.springframework.stereotype.Service;

@Service
public class JWTService {
    public String generateToken(MyUser user) {
        return user.getUsername();
    }
}
