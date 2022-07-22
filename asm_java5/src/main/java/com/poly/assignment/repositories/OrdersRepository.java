package com.poly.assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.assignment.entities.Customer;
import com.poly.assignment.entities.Order;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Order, Integer> {
    @Query("select u from Order u where u.customer = ?1")
    List<Order> findByCutomer(Customer customer);
    
}
