package com.example.quanlynhahang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.quanlynhahang.entity.OrderItem;
import com.example.quanlynhahang.service.BillService;


@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("/{tableId}")
    public String showBill(@PathVariable int tableId, Model model) {
        List<OrderItem> orders = billService.getOrdersByTable(tableId);
        double total = billService.calculateTotal(orders);

        model.addAttribute("tableId", tableId);
        model.addAttribute("orders", orders);
        model.addAttribute("total", total);

        return "bill";
    }
}
