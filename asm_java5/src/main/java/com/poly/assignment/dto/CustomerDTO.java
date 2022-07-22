package com.poly.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;



public class CustomerDTO implements Serializable {

	private int customerId;


	private String email;


	private String name;


	private String password;


	private String phone;


	private Date registeredDate;


	private int status;
	private Boolean isEdit = false;
public CustomerDTO() {
	// TODO Auto-generated constructor stub
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Date getRegisteredDate() {
	return registeredDate;
}
public void setRegisteredDate(Date registeredDate) {
	this.registeredDate = registeredDate;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public Boolean getIsEdit() {
	return isEdit;
}
public void setIsEdit(Boolean isEdit) {
	this.isEdit = isEdit;
}

}