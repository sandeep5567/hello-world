package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Blog;

public interface BlogDAO {

	public List<Blog> list();
	
	public Blog getBlog(String blogId);
	
	public void saveorupdate(Blog blog);
	
	public void delete(String blogId);
	
}
