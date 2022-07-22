package com.poly.assignment.dto;

 

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
 

 

public class OrderDTO {


	private int orderId;

	private Date orderDate;


	private BigDecimal amount;


	private short status;

public OrderDTO() {
	// TODO Auto-generated constructor stub
}

public int getOrderId() {
	return orderId;
}

public void setOrderId(int orderId) {
	this.orderId = orderId;
}

public Date getOrderDate() {
	return orderDate;
}

public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}

public BigDecimal getAmount() {
	return amount;
}

public void setAmount(BigDecimal amount) {
	this.amount = amount;
}

public short getStatus() {
	return status;
}

public void setStatus(short status) {
	this.status = status;
}
}
