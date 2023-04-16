package com.lab1.movieapp.services;

import com.lab1.movieapp.dao.MovieDao;
import com.lab1.movieapp.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie acceptMovieDetails(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public List<Movie> acceptMultipleMovieDetails(List<Movie> movies) {

        List<Movie> savedMovies = new ArrayList<>();

        for (Movie movie:movies) {
            savedMovies.add(movieDao.save(movie));
        }

        return savedMovies;
    }

    @Override
    public Movie getMovieDetails(int id) {
        return movieDao.findById(id).get();
    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) {
        Movie savedMovie = getMovieDetails(id);
        savedMovie.setMovieDescription(movie.getMovieDescription());
        savedMovie.setMovieName(movie.getMovieName());
        savedMovie.setDuaraion(movie.getDuaraion());
        savedMovie.setReleaseDate(movie.getReleaseDate());
        savedMovie.setTrailerUrl(movie.getTrailerUrl());
        savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());


        return acceptMovieDetails(savedMovie);


    }

    @Override
    public boolean deleteMovie(int id) {

        Movie savedMovie = getMovieDetails(id);

        if (savedMovie == null) {
            return false;
        }
        movieDao.delete(savedMovie);
        return true;
    }

    @Override
    public List<Movie> getAllMovie() {
        return movieDao.findAll();
    }

    @Override
    public Page<Movie> getPaginatedMovieDetails(Pageable pageable) {
        return movieDao.findAll(pageable);
    }
}
