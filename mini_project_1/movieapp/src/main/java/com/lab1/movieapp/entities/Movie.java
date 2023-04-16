package com.lab1.movieapp.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;

    @Column(length = 50, nullable = false, unique = true)
    private String movieName;

    @Column(length=500, name="movie_desc", nullable = false)
    private String movieDescription;

    @Column(nullable = false)
    private LocalDateTime releaseDate;

    @Column(nullable = false)
    private int duaraion;

    @Column(length = 500,nullable = false)
    private String coverPhotoUrl;

    @Column(length = 500, nullable = false)
    private String trailerUrl;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuaraion() {
        return duaraion;
    }

    public void setDuaraion(int duaraion) {
        this.duaraion = duaraion;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                ", releaseDate=" + releaseDate +
                ", duaraion=" + duaraion +
                ", coverPhotoUrl='" + coverPhotoUrl + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                '}';
    }
}
