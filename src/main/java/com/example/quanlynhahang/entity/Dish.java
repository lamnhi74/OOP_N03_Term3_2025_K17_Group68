package com.example.quanlynhahang.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Price", nullable = false)
    private double price;

    public Dish() {}

    public Dish(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public void setID(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Dish{id=" +id+ ", name= " +name+ ", price= " +price+ "}";
    }
}
