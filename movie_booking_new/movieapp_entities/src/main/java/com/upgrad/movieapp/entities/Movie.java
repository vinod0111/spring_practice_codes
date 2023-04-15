package com.upgrad.movieapp.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Movie {

    @Id
    @Column(length = 10)
    private int movieID;

    @Column(length = 50, nullable = false, unique = true)
    private String movieName;

    @Column(length = 500, nullable = false)
    private String movieDesc;

    @Column(nullable = false)
    private LocalDateTime releaseData;

    @Column(columnDefinition = "INTEGER CHECK (duration > 60)")
    private int duration;

    @Column(nullable = false, length = 500)
    private String coverPhotoUrl;

    @Column(nullable = false, length = 500)
    private String trailerUrl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status statusId;

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    public LocalDateTime getReleaseData() {
        return releaseData;
    }

    public void setReleaseData(LocalDateTime releaseData) {
        this.releaseData = releaseData;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieID=" + movieID +
                ", movieName='" + movieName + '\'' +
                ", movieDesc='" + movieDesc + '\'' +
                ", releaseData=" + releaseData +
                ", duration=" + duration +
                ", coverPhotoUrl='" + coverPhotoUrl + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                ", statusId=" + statusId +
                '}';
    }
}
