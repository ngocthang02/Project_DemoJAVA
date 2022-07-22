package com.poly.assignment.entities;



import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name="orderdetails")

public class OrderDetail implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderDetailId;


	@Column(nullable = false)
	private int quantity;

	@Column(nullable = false)
	private BigDecimal unitPrice;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Vegetable product;

	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;
public OrderDetail() {
	// TODO Auto-generated constructor stub
}
public Integer getOrderDetailId() {
	return orderDetailId;
}
public void setOrderDetailId(Integer orderDetailId) {
	this.orderDetailId = orderDetailId;
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
public Vegetable getProduct() {
	return product;
}
public void setProduct(Vegetable product) {
	this.product = product;
}
public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}
}


