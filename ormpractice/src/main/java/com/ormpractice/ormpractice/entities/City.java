package com.ormpractice.ormpractice.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class City {

    @Id
    @GeneratedValue
    private int cityId;

    @Column(length = 60, nullable = false)
    private String cityName;

    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private Set<Theatre> theatres;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Set<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(Set<Theatre> theatres) {
        this.theatres = theatres;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", theatres=" + theatres +
                '}';
    }
}
