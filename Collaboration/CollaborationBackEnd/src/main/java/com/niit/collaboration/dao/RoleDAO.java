package com.niit.collaboration.dao;

import com.niit.collaboration.model.Role;

public interface RoleDAO {

    public void saveorupdate(Role role);
	
	public void delete(String roleId);

}
