package com.example.quanlynhahang.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.quanlynhahang.repository.DishRepo;
import com.example.quanlynhahang.entity.Dish;
import java.util.*;

@RestController
@RequestMapping("/menu")

public class MenuController {
    @Autowired
    private DishRepo dishRepo;

    // tạo món
    @PostMapping("/tables/create/{id}")
    public void createDish(@RequestBody Dish dish) {
        dishRepo.save(dish);
    }

    // sửa món ăn
    @PutMapping("/tables/update/{id}")
    public void updateDish(@RequestBody Dish dish){
        dishRepo.save(dish);
    }

    // xóa món ăn
    @DeleteMapping("/tables/delete/{id}")
    public void deleteDishByID(@PathVariable int id){
        dishRepo.deleteById(null);
    }

    // in menu
    @GetMapping("/tables/view")
    public List<Dish> getAllDishes() {
        return dishRepo.findAll();
    }

    @GetMapping("/dishes")
    public String showList (Model model){
        model.addAttribute("Dish1", new Dish(290, "Phở", 35.00));
        model.addAttribute("Dish2", new Dish(360, "Nem chua", 15.00));
        model.addAttribute("Dish3", new Dish(750, "Bún bò Huế", 35.00));
        return "menu";
    }
    
}
