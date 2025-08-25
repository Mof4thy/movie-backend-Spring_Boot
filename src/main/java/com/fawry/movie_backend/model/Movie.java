package com.fawry.movie_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

// tell jpa that this is a table
@Entity
@Table(name = "movies")
public class Movie {

    // 🔹 columns
    // tell jpa that this is the primary key
    @Id
    private String imdbID;    // IMDB ID as primary key    
    private String title;
    
    @Column(name = "movie_year")
    private String year;
    private String type;

    private String poster;

    // 🔹 default constructor (required by JPA)
    public Movie() {}

    // 🔹 getters and setters
    //Java keeps variables private (can't be touched from outside).
    //Getters and setters are like controlled access doors.

    
    public String getImdbID() { return imdbID; }
    public void setImdbID(String imdbID) { this.imdbID = imdbID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getPoster() { return poster; }
    public void setPoster(String poster) { this.poster = poster; }
}

