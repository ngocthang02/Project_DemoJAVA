package com.poly.assignment.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.assignment.entities.Vegetable;

import java.util.List;

public interface VegetableRepository  extends JpaRepository<Vegetable, Long> {
    List<Vegetable> findByNameContaining(String name);
    Page<Vegetable> findByNameContaining(String name, Pageable pageable);
}
