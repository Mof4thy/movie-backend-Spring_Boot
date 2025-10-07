package com.fawry.movie_backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fawry.movie_backend.model.Movie;
import com.fawry.movie_backend.repository.MovieRepository;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{imdbID}")
    public Movie getMovieById(@PathVariable String imdbID) {
        
        return movieRepository.findById(imdbID)
        .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        if (movieRepository.findById(movie.getImdbID()).isPresent()) {
            throw new RuntimeException("Movie already exists");
        }
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{imdbID}")
    public void deleteMovie(@PathVariable String imdbID) {
        if (!movieRepository.findById(imdbID).isPresent()) {
            throw new RuntimeException("Movie not found");
        }
        movieRepository.deleteById(imdbID);
    }

    @PostMapping("/batch")
    public List<Movie> addMovies(@RequestBody List<Movie> movies){
        for (Movie movie : movies) {
            if (movieRepository.findById(movie.getImdbID()).isPresent()) {
                throw new RuntimeException("Movie already exists");
            }
        }
        return movieRepository.saveAll(movies); 
    }

    @DeleteMapping("/batch")
    public void deleteMovies(@RequestBody List<String> imdbIDs){
        for (String imdbID : imdbIDs) {
            if (!movieRepository.findById(imdbID).isPresent()) {
                throw new RuntimeException("Movie not found");
            }
        }
        movieRepository.deleteAllById(imdbIDs);
    }
}
