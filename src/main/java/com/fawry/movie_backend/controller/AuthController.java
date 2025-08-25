package com.fawry.movie_backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fawry.movie_backend.model.User;
import com.fawry.movie_backend.repository.UserRepository;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")

public class AuthController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setRole("USER");
        return userRepository.save(user);
    }


    @PostMapping("/login")
    public Object login(@RequestBody User loginData) {
        User user = userRepository.findByUsername(loginData.getUsername());

        if (user == null || !user.getPassword().equals(loginData.getPassword())) {
            return "Invalid username or password";
        }

        return new AuthResponse(user.getUsername(), user.getRole());
    }
    
    record AuthResponse(String username, String role) {}
    
}
