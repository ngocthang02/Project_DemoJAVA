package com.poly.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;




public class VegetableDTO implements Serializable {


    private Long productID;

    private String name;

    private int quantity;

    private BigDecimal unitPrice;

    private String image;
    
    @NotNull
    private MultipartFile imageFile;

    private String description;


    private double discount;


    private Date enteredDate;


    private short status;
    private Long categoryID;

    private Boolean isEdit = false;
public VegetableDTO() {
	// TODO Auto-generated constructor stub
}
public Long getProductID() {
	return productID;
}
public void setProductID(Long productID) {
	this.productID = productID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public MultipartFile getImageFile() {
	return imageFile;
}
public void setImageFile(MultipartFile imageFile) {
	this.imageFile = imageFile;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getDiscount() {
	return discount;
}
public void setDiscount(double discount) {
	this.discount = discount;
}
public Date getEnteredDate() {
	return enteredDate;
}
public void setEnteredDate(Date enteredDate) {
	this.enteredDate = enteredDate;
}
public short getStatus() {
	return status;
}
public void setStatus(short status) {
	this.status = status;
}
public Long getCategoryID() {
	return categoryID;
}
public void setCategoryID(Long categoryID) {
	this.categoryID = categoryID;
}
public Boolean getIsEdit() {
	return isEdit;
}
public void setIsEdit(Boolean isEdit) {
	this.isEdit = isEdit;
}

}
