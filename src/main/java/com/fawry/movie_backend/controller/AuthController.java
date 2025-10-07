package com.fawry.movie_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            if (userRepository.findByUsername(user.getUsername()) != null) {
                return ResponseEntity.badRequest().body("Username already exists");
            }
            
            if (user.getPassword().length() < 6) {
                return ResponseEntity.badRequest().body("Password must be at least 6 characters long");
            }
            
            // Create new user
            user.setRole("USER");
            User savedUser = userRepository.save(user);
            
            return ResponseEntity.ok(savedUser);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Registration failed: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginData) {
        try {
            User user = userRepository.findByUsername(loginData.getUsername());

            if (user == null || !user.getPassword().equals(loginData.getPassword())) {
                return ResponseEntity.badRequest().body("Invalid username or password");
            }
            
            return ResponseEntity.ok(new AuthResponse(user.getUsername(), user.getRole()));
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Login failed: " + e.getMessage());
        }
    }
    
    // Response record for successful login
    public record AuthResponse(String username, String role) {}
}