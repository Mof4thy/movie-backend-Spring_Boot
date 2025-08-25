// 🔹 repository = database access layer.
// 🔹 repository is the layer that interacts with the database
package com.fawry.movie_backend.repository;

// 🔹 import the movie model
import com.fawry.movie_backend.model.Movie;

// 🔹 import the jpa repository
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 🔹 create the repository interface
@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
     // We can add custom queries later if needed
        
}


// ✅ JpaRepository<Movie, String> gives you:
// save(movie) → insert or update a movie

// findAll() → get all movies

// findById(id) → get one movie by id

// deleteById(id) → remove a movie