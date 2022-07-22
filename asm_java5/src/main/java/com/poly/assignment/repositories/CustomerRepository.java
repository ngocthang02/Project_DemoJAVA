package com.poly.assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.assignment.entities.Customer;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {

    List<Customer> findByNameContaining(String name);
    List<Customer> findByEmailContaining(String email);
}
