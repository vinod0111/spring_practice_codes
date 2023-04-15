package com.upgrad.movieapp.entities;

import javax.persistence.*;

@Entity
public class MovieTheatre {

    @Id
    @GeneratedValue
    private int movieTheatreId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    public int getMovieTheatreId() {
        return movieTheatreId;
    }

    public void setMovieTheatreId(int movieTheatreId) {
        this.movieTheatreId = movieTheatreId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    @Override
    public String toString() {
        return "MovieTheatre{" +
                "movieTheatreId=" + movieTheatreId +
                ", movie=" + movie +
                ", theatre=" + theatre +
                '}';
    }
}
