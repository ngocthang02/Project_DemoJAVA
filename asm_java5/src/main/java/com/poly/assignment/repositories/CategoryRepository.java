package com.poly.assignment.repositories;


 
import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.assignment.entities.Category;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByNameContaining(String name);

}
