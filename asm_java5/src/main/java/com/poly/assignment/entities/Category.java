package com.poly.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
 
import java.io.Serializable;
import java.util.List;
 

/**
 * The persistent class for the CATEGORYS database table.
 */
 
@Entity
@Table(name = "Categories")

public class Category implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryID;


	@Column(name = "category_name", length = 100, columnDefinition = "nvarchar(100) not null")
	private String name;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Vegetable> products;

public Category() {
	// TODO Auto-generated constructor stub
}

public Long getCategoryID() {
	return categoryID;
}

public void setCategoryID(Long categoryID) {
	this.categoryID = categoryID;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Vegetable> getProducts() {
	return products;
}

public void setProducts(List<Vegetable> products) {
	this.products = products;
}


}