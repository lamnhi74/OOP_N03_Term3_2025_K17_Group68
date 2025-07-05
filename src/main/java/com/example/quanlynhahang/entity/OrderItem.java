package com.example.quanlynhahang.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private int orderId;
    @Column(name = "DishId", nullable = false)
    private int dishId;
    @Column(name = "DishName", nullable = false)
    private String dishName;
    @Column(name = "DishPrice", nullable = false)
    private double dishPrice;
    @Column(name = "DishQuantity", nullable = false)
    private int dishQuantity;
    @Column(name = "TableId", nullable = false)
    private int tableId;

    OrderItem (){}

    public OrderItem(int orderId, int dishId, String dishName, double dishPrice, int dishQuantity, int tableId) {
        this.orderId = orderId;
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishQuantity = dishQuantity;
        this.tableId = tableId;
    }

    public int getDishId() {
        return dishId;
    }
    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getDishPrice() {
        return dishPrice;
    }
    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public int getDishQuantity() {
        return dishQuantity;
    }
    public void setDishQuantity(int dishQuantity) {
        this.dishQuantity = dishQuantity;
    }

    public int getTableId() {
        return tableId;
    }
    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    
}
