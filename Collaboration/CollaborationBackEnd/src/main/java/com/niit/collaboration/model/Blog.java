package com.niit.collaboration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "BLOG")
@Component
public class Blog {

	private String blogId;
	private Date blogDate;
	private String title;
	private String message;
	private String status;
	private Users user;

	@Id
	@Column(name="BLOG_ID")
	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	@Column(name="BLOG_DATE")
	public Date getBlogDate() {
		return blogDate;
	}

	public void setBlogDate(Date blogDate) {
		this.blogDate = blogDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID",nullable=false)
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
}
