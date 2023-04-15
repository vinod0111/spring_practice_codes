package com.example.jpa_entity_factory.dao;

import com.example.jpa_entity_factory.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {

}
