package com.example.quanlynhahang.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.quanlynhahang.entity.Dish;
import com.example.quanlynhahang.entity.DishItem;
import com.example.quanlynhahang.repository.DishRepo;
import com.example.quanlynhahang.service.OrderService;


@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private final DishRepo dishRepo;

    @Autowired
    private OrderService orderService;

    private List<Dish> selectedDishes = new ArrayList<>();
    private final List<DishItem> selectedItems = new ArrayList<>();
    public OrderController(DishRepo dishRepo) {
        this.dishRepo = dishRepo;
    }

    @GetMapping("/order/dishes")
    public String getAllDishes(Model model) {
        model.addAttribute("dishes", orderService.findAll());
        model.addAttribute("dish", new Dish());
        return "order";
    }

    @PostMapping("/order/add")
    public String addDish(@RequestParam int dishId, @RequestParam int quantity, Model model) {

        Optional<Dish> optionalDish = dishRepo.findById(dishId);
        if (optionalDish.isPresent()) {
            Dish dish = optionalDish.get();
            selectedItems.add(new DishItem(dish, quantity));
        } else {
            model.addAttribute("error", "Không tìm thấy món ăn với ID: " + dishId);
        }

        model.addAttribute("selectedItems", selectedItems);
        return "order";
    }

    @GetMapping("/")
    public String showOrderPage(Model model) {
        model.addAttribute("selectedDishes", selectedDishes);
        return "order";
    }
}
