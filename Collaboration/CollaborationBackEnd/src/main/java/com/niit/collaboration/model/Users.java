package com.niit.collaboration.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "USERS")
@Component
public class Users {

	private String userId;
	private String userName;
	private String password;
	private String email;
	private String status;
	private Set<Role> role;
	private Set<Blog> blog;

	@Id
	@Column(name="USER_ID")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), 
	           inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	@OneToMany(fetch=FetchType.EAGER,mappedBy="user")
	public Set<Blog> getBlog() {
		return blog;
	}

	public void setBlog(Set<Blog> blog) {
		this.blog = blog;
	}
	
}
