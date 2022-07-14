package com.example.birjiwalademo.repository;

import com.example.birjiwalademo.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Integer> {
    List<Price> findByComponent(String cname);
}