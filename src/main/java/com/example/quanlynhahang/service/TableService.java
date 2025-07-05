package com.example.quanlynhahang.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quanlynhahang.entity.Tablee;
import com.example.quanlynhahang.repository.TableRepo;


@Service
public class TableService {
     @Autowired
    private TableRepo tableRepo;

    public List<Tablee> getAllTables() {
        return tableRepo.findAll();
    }

    public void updateStatus(int id, boolean occupied) {
        Optional<Tablee> tableOp = tableRepo.findById(id);
        if (tableOp.isPresent()) {
            Tablee table = tableOp.get();
            table.setOccupied(occupied);
            tableRepo.save(table);
        }
    }

    public void isTableEmpty() {
        if (tableRepo.count() == 0) {
            for (int i = 1; i <= 5; i++) {
                tableRepo.save(new Tablee(i, false));
            }
        }
    }
}
