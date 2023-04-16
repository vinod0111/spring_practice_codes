package com.lab1.movieapp.dao;

import com.lab1.movieapp.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie, Integer> {

}
