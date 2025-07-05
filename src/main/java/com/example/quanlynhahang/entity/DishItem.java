package com.example.quanlynhahang.entity;

public class DishItem {
    private Dish dish;
    private int quantity;

    public DishItem(Dish dish, int quantity) {
        this.dish = dish;
        this.quantity = quantity;
    }

    public Dish getDish() {
        return dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return dish.getPrice() * quantity;
    }
}
