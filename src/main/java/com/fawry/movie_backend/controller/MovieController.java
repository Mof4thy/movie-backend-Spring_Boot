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
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{imdbID}")
    public void deleteMovie(@PathVariable String imdbID) {
        movieRepository.deleteById(imdbID);
    }

    @PostMapping("/batch")
    public List<Movie> addMovies(@RequestBody List<Movie> movies){
        return movieRepository.saveAll(movies); 
    }

    @DeleteMapping("/batch")
    public void deleteMovies(@RequestBody List<String> imdbIDs){
        movieRepository.deleteAllById(imdbIDs);
    }


}
