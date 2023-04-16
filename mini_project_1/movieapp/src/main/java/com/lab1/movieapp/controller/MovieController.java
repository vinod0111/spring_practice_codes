package com.lab1.movieapp.controller;

import com.lab1.movieapp.dto.MovieDTO;
import com.lab1.movieapp.entities.Movie;
import com.lab1.movieapp.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/movie_app/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    ModelMapper modelMapper;
    /**
     * method for creating movie
     * /movies
     */

    @PostMapping(value = "/movies", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMovie(@RequestBody MovieDTO movieDTO){

        // convert movieDTO to movieENtity
        Movie newMovie = modelMapper.map(movieDTO, Movie.class);
        Movie savedMovie = movieService.acceptMovieDetails(newMovie);
        MovieDTO saveMovieDto = modelMapper.map(savedMovie, MovieDTO.class);

        return new ResponseEntity(saveMovieDto, HttpStatus.OK);
    }

    @GetMapping(value = "/movies", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllMovies(){

        List<Movie> movieList = movieService.getAllMovie();

        List<MovieDTO> movieDTOList = new ArrayList<>();

        for (Movie movie: movieList) {
            movieDTOList.add(modelMapper.map(movie, MovieDTO.class));
        }

        return new ResponseEntity(movieDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/movies/{id}")
    public ResponseEntity getMovieById(@PathVariable(name = "id") int id) {

        Movie movie = movieService.getMovieDetails(id);

        MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);

        return new ResponseEntity(movieDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/movies/{id}")
    public ResponseEntity updateMovieDetails(@PathVariable(name = "id") int id, @RequestBody MovieDTO movieDTO) {

        Movie newMovie = modelMapper.map(movieDTO, Movie.class);

        MovieDTO updatedMovieDTO = modelMapper.map(newMovie, MovieDTO.class);

        return new ResponseEntity(updatedMovieDTO, HttpStatus.OK);
    }


}
