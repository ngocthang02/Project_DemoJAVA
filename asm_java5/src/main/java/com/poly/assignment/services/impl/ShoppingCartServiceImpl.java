package com.poly.assignment.services.impl;

import com.poly.assignment.dto.CartItemDTO;
import com.poly.assignment.entities.CartItem;
import com.poly.assignment.entities.Vegetable;
import com.poly.assignment.services.ShoppingCartService;
import com.poly.assignment.services.VegetableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
	private VegetableService vegetableService;
	private Map<Long, CartItemDTO> map = new HashMap<>();

	// them 1 sp vao gio hang

	@Override
	public void add(CartItemDTO item) {
		// kiem tra sp co trong gio hang chua
		CartItemDTO exitCartItem = map.get(item.getProductID());
		if (exitCartItem != null) {
			exitCartItem.setQuantity(item.getQuantity() + exitCartItem.getQuantity());
		} else {
			map.put(item.getProductID(), item);
		}

	}

	// xoa sp trong gio hang

	@Override
	public void remove(Long productID) {
		map.remove(productID);
	}

	// lay danh sach sp

	@Override
	public Collection<CartItemDTO> getProduct() {
		return map.values();
	}

	// xoa tat ca sp trong gio hang

	@Override
	public void clear() {
		map.clear();
	}

	// update sp trong gio hang

	@Override
	public void update(Long productID, int quantity) {
		CartItemDTO item = map.get(productID);
		item.setQuantity(quantity);

		if (item.getQuantity() <= 0) {

			map.remove(productID);
		}

	}

	
	@Override
	public void updatePrice(Long productID) {
		CartItemDTO item = map.get(productID);
		Vegetable vegetable = vegetableService.getOne(productID);
		item.setUnitPrice(vegetable.getUnitPrice());

	}

	@Override
	public CartItemDTO getById(long id) {

		return map.get(id);
	}

	// tính tổng giá trên hóa đơn

	@Override
	public BigDecimal getAmount() {

		// return map.values().stream().mapToDouble(item -> item.getQuantity() *
		// item.getUnitPrice()).sum();

		BigDecimal cartTotal = BigDecimal.ZERO;
		for (Entry<Long, CartItemDTO> entry : map.entrySet()) {
			cartTotal = cartTotal
					.add(entry.getValue().getUnitPrice().multiply(new BigDecimal(entry.getValue().getQuantity())));

		}
//		for (Map.Entry<Long, CartItem> itemCart : map.entrySet()) {
//			
//		}
		return cartTotal;

	}

	// lay sl tat ca sp

	@Override
	public int getCount() {
		if (map.isEmpty()) {
			return 0;
		} else {
			//return map.values().size();
			return map.values().stream().mapToInt(i -> i.getQuantity()).sum();
		}
	}

}
