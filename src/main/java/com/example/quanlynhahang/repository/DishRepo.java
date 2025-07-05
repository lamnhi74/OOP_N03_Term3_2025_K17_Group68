package com.example.quanlynhahang.repository;

import com.example.quanlynhahang.entity.Dish;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepo extends JpaRepository<Dish, Integer>{
    Optional<Dish> findByName(String name);
}