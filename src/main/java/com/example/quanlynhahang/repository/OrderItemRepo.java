package com.example.quanlynhahang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quanlynhahang.entity.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByTableId(int tableId);
}
