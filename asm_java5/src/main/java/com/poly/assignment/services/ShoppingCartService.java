package com.poly.assignment.services;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.poly.assignment.dto.CartItemDTO;
@Service
public interface ShoppingCartService {


    void add(CartItemDTO item);

    void remove(Long productID);

    Collection<CartItemDTO> getProduct();

    void clear();

   

   

    int getCount();

	void update(Long productID, int quantity);

	CartItemDTO getById(long id);

	BigDecimal getAmount();

	void updatePrice(Long productID);

	
}
