package com.upgrad.movieapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Status {

    @Id
    @Column(length = 10)
    private int status_id;
    @Column(nullable = false, unique = true, length = 20)
    private String statusName;

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status_id=" + status_id +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
