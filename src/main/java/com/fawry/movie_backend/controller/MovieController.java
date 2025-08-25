// 🔹 controller = the layer that handles the requests and responses.

package com.fawry.movie_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fawry.movie_backend.model.Movie;
import com.fawry.movie_backend.repository.MovieRepository;

import java.util.List;

// 🔹 create the controller
// 🔹 tells Spring this class handles API requests
@RestController
@RequestMapping("/api/movies") // all routes start with /api/movies
@CrossOrigin(origins = "http://localhost:4200") // allow Angular frontend to call backend
public class MovieController {

    // 🔹 (connects) the repository automatically. (dependency injection) without creating it manuall
    @Autowired
    private MovieRepository movieRepository;

    // 🔹 get all movies
    //   GET /api/movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // 🔹 get a movie by imdbID
    //   GET /api/movies/{imdbID}
    @GetMapping("/{imdbID}")
    public Movie getMovieById(@PathVariable String imdbID) {
        return movieRepository.findById(imdbID)
        .orElseThrow(() -> new RuntimeException("Movie not found"));
    }
    

    // 🔹 add a new movie
    //   POST /api/movies
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    // 🔹 delete a movie by imdbID
    //   DELETE /api/movies/{imdbID}
    @DeleteMapping("/{imdbID}")
    public void deleteMovie(@PathVariable String imdbID) {
        movieRepository.deleteById(imdbID);
    }


    // 🔹 add multiple movies
    //   POST /api/movies/batch
    @PostMapping("/batch")
    public List<Movie> addMovies(@RequestBody List<Movie> movies){
        return movieRepository.saveAll(movies); 
    }


    // 🔹 delete multiple movies
    //   DELETE /api/movies/batch
    @DeleteMapping("/batch")
    public void deleteMovies(@RequestBody List<String> imdbIDs){
        movieRepository.deleteAllById(imdbIDs);
    }


}
