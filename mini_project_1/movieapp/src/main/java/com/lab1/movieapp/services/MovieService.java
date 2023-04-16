package com.lab1.movieapp.services;

import com.lab1.movieapp.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {

    public Movie acceptMovieDetails(Movie movie);

    public List<Movie> acceptMultipleMovieDetails(List<Movie> movies);

    public Movie getMovieDetails(int id);

    public Movie updateMovieDetails(int id, Movie movie);

    public boolean deleteMovie(int id);

    public List<Movie> getAllMovie();

    public Page<Movie> getPaginatedMovieDetails(Pageable pageable);
}
