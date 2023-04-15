package com.ormpractice.ormpractice.entities;

import jakarta.persistence.*;

@Entity
public class Theatre {

    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    private int theatreId;

    @Column(length = 40, nullable = false)
    private String theatreName;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreId=" + theatreId +
                ", theatreName='" + theatreName + '\'' +
                ", city=" + city +
                '}';
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
