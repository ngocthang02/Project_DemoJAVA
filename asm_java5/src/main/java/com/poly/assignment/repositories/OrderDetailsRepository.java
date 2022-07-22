package com.poly.assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.assignment.dto.OrderDetailDTO;
import com.poly.assignment.entities.Order;
import com.poly.assignment.entities.OrderDetail;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetail, Integer> {
    @Query("select u from OrderDetail u where u.order = ?1")
    List<OrderDetail> findByOrder(Order order);

}
