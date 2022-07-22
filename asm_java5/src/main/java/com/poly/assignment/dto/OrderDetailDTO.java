package com.poly.assignment.dto;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.math.BigDecimal;

import com.poly.assignment.entities.Vegetable;


public class OrderDetailDTO implements Serializable {



	private Integer orderDetailId;

	private int orderId;

	private Vegetable productId;


	private int quantity;


	private BigDecimal unitPrice;

public OrderDetailDTO() {
	// TODO Auto-generated constructor stub
}

public Integer getOrderDetailId() {
	return orderDetailId;
}

public void setOrderDetailId(Integer orderDetailId) {
	this.orderDetailId = orderDetailId;
}

public int getOrderId() {
	return orderId;
}

public void setOrderId(int orderId) {
	this.orderId = orderId;
}

public Vegetable getProductId() {
	return productId;
}

public void setProductId(Vegetable productId) {
	this.productId = productId;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public BigDecimal getUnitPrice() {
	return unitPrice;
}

public void setUnitPrice(BigDecimal unitPrice) {
	this.unitPrice = unitPrice;
}
}


