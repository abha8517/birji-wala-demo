package com.example.birjiwalademo.repository;

import com.example.birjiwalademo.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, String> {
}