package com.example.tjcodde.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tjcodde.UserRepository.UserRepository;
import com.example.tjcodde.userEntity.UserEntity;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*") // Allow frontend to connect
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity) {
        try {
            // Check if email already exists
            if (userRepository.existsByEmail(userEntity.getEmail())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email already registered");
            }
            
            // Validate Gmail format
            if (!userEntity.getEmail().endsWith("@gmail.com")) {
                return ResponseEntity.badRequest()
                    .body("Only Gmail addresses are accepted");
            }
            
            UserEntity savedUser = userRepository.save(userEntity);
            return ResponseEntity.ok(savedUser);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Registration failed: " + e.getMessage());
        }
    }
    
    // Optional: Get all registered users (for your manual process)
    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        try {
            return ResponseEntity.ok(userRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to fetch users");
        }
    }
}