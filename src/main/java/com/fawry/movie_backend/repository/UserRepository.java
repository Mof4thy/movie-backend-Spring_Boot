package com.fawry.movie_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fawry.movie_backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
}