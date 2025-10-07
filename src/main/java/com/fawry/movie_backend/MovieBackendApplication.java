package com.fawry.movie_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.fawry.movie_backend.model.User;
import com.fawry.movie_backend.repository.UserRepository;

@SpringBootApplication
public class MovieBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieBackendApplication.class, args);
	}

	@Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            if (userRepository.findByUsername("admin") == null) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword("admin123"); 
                admin.setRole("ADMIN");
                userRepository.save(admin);
            }
        };
    }
	
}





