package com.poly.assignment.entities;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the ACCOUNTS database table.
 * 
 */
 
@Entity
@Table(name="accounts")

public class Account implements Serializable {


	@Id
	@Column(length = 30)
	private String username;


	@Column(length = 20, nullable = false)
	private String password;
public Account() {
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

}