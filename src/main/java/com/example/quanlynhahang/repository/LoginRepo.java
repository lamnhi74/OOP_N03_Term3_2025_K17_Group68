package com.example.quanlynhahang.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quanlynhahang.entity.Login;

public interface LoginRepo extends JpaRepository<Login, Integer> {
     Optional<Login> findByUsername(String username);
}
