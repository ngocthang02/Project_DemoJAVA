package com.poly.assignment.dto;

 

 
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


/**
 * The persistent class for the ACCOUNTS database table.
 * 
 */
 


public class AccountDTO implements Serializable {
	@NotEmpty
	private String username;

	@NotEmpty
	private String password;
	private Boolean isEdit = false;
public AccountDTO() {
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
public Boolean getIsEdit() {
	return isEdit;
}
public void setIsEdit(Boolean isEdit) {
	this.isEdit = isEdit;
}
}