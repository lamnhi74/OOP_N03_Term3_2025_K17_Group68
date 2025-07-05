package com.example.quanlynhahang.repository;

import com.example.quanlynhahang.entity.Tablee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepo extends JpaRepository<Tablee, Integer>{

}
