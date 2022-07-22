package com.poly.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the CATEGORYS database table.
 */



public class CategoryDTO implements Serializable {



	private Long categoryID;

	@NotEmpty


	private String name;

	private Boolean isEdit = false;



public CategoryDTO() {
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



public Boolean getIsEdit() {
	return isEdit;
}



public void setIsEdit(Boolean isEdit) {
	this.isEdit = isEdit;
}

}