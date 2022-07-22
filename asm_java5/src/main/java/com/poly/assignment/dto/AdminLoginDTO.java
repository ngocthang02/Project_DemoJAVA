package com.poly.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


/**
 * The persistent class for the ACCOUNTS database table.
 * 
 */
 


public class AdminLoginDTO implements Serializable {
	@NotEmpty
	private String username;

	@NotEmpty
	private String password;

	private Boolean rememberMe = false;
public AdminLoginDTO() {
	// TODO Auto-generated constructor stub
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Boolean getRememberMe() {
	return rememberMe;
}
public void setRememberMe(Boolean rememberMe) {
	this.rememberMe = rememberMe;
}
}