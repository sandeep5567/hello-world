package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Users;

public interface UserDAO {

    public List<Users> list();
	
	public Users get(String userId);
	
	public void saveorupdate(Users user);
	
	public void delete(String userId);

	public boolean isValidUser(String username, String password);
}
