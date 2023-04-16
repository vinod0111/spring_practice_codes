package com.lab1.movieapp.dto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class MovieDTO {

    private int movieId;

    private String movieName;

    private String movieDescription;

    private LocalDateTime releaseDate;

    private int duaraion;

    private String coverPhotoUrl;

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
}
