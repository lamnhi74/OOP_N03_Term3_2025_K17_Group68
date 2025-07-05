package com.example.quanlynhahang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quanlynhahang.entity.OrderItem;
import com.example.quanlynhahang.repository.OrderItemRepo;

@Service
public class BillService {
    @Autowired
    private OrderItemRepo orderRepo;

    public List<OrderItem> getOrdersByTable(int tableId) {
        return orderRepo.findByTableId(tableId);
    }

    public double calculateTotal(List<OrderItem> orders) {
        return orders.stream().mapToDouble(o -> o.getDishPrice() * o.getDishQuantity()).sum();
    }
}
