package com.upgrad.movieapp.entities;

import javax.persistence.*;

@Entity
public class Theatre {

    @Id
    @GeneratedValue
    private int theatreId;

    @Column(nullable = false, unique = false)
    private String theatreName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(columnDefinition = "Decimal(10,2) default '150.00'", nullable = false)
    private double ticketPrice;

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

    public City getCityID() {
        return city;
    }

    public void setCityID(City cityID) {
        this.city = city;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreId=" + theatreId +
                ", theatreName='" + theatreName + '\'' +
                ", cityID=" + city +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
