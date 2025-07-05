package com.example.quanlynhahang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.quanlynhahang.service.TableService;

@Controller
public class TableController {
    @Autowired
    private TableService tableService;

    @GetMapping("/tables")
    public String showTables(Model model) {
        tableService.isTableEmpty();
        model.addAttribute("tables", tableService.getAllTables());
        return "table_list";
    }

    @PostMapping("/tables/clear/{id}")
    public String clearTable(@PathVariable int id) {
        tableService.updateStatus(id, false);
        return "redirect:/tables";
    }

    @PostMapping("/tables/select/{id}")
    public String selectTable(@PathVariable int id) {
        tableService.updateStatus(id, true);
        return "redirect:/order/" + id;
    }
}
