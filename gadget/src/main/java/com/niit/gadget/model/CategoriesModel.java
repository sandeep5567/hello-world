package com.niit.gadget.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.Entity;
//import org.hibernate.annotations.Table;

@Entity
@Table(name="category")
public class CategoriesModel {
	
	@Id
	@Column
		private String cat_id;
	@Column
	private String  cat_name;
	@Column
	private String cat_des;
	public String getCat_id() {
		return cat_id;
	}
	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public String getCat_des() {
		return cat_des;
	}
	public void setCat_des(String cat_des) {
		this.cat_des = cat_des;
	}
	
	
	
	
	

}
