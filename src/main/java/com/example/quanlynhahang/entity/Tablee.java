package com.example.quanlynhahang.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tablee {
    @Id
    private int id;
    private boolean isOccupied;

    public Tablee(int id, boolean isOccupied) {
        this.id = id;
        this.isOccupied = isOccupied;
    }

    public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return id + " , " + isOccupied;
    }
}
