package com.niit.collaboration.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.model.Role;

@Repository("roleDao")
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public RoleDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public void saveorupdate(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
	}

	@Transactional
	public void delete(String roleId) {
		Role roleToDelete = new Role();
		roleToDelete.setRoleName(roleId);
		sessionFactory.getCurrentSession().delete(roleToDelete);
	}

}
