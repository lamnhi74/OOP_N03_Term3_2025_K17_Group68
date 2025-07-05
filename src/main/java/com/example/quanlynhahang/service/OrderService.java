package com.example.quanlynhahang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quanlynhahang.entity.Dish;
import com.example.quanlynhahang.repository.DishRepo;

@Service
public class OrderService {
    @Autowired
    private DishRepo dishRepo;

    public List<Dish> findAll() {
        return dishRepo.findAll();
    }

    public Dish addDish(Dish dish) {
        return dishRepo.save(dish);
    }

    public void deleteById(int id) {
        dishRepo.deleteById(id);
    }
}
