package com.example.tjcodde.userEntity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emails")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    // Default constructor
    public UserEntity() {
        this.createdAt = LocalDateTime.now();
    }
    
    // Constructor with email
    public UserEntity(String email) {
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }
    
    // Constructor with all fields (for compatibility with your existing code)
    public UserEntity(Long id, String email) {
        this.id = id;
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}