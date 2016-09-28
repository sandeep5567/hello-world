package com.niit.collaboration.test;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.Role;
import com.niit.collaboration.model.Users;

public class TestUser {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();
		
		Set<Users> user1 = new HashSet<Users>();
		
		Set<Role> roles1 = new HashSet<Role>();
	
		Users users1 = (Users) context.getBean("users");
		users1.setUserId("U001");
		users1.setUserName("Rahul Thakur");
		users1.setPassword("password");
		users1.setEmail("rahul.com");
		users1.setStatus("New");
		user1.add(users1);
		
		Role role1 = (Role) context.getBean("role");
		role1.setRoleId("R001");
		role1.setRoleName("Employee");
		roles1.add(role1);
		
		users1.setRole(roles1);
		role1.setUser(user1);
		
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		
		userDAO.saveorupdate(users1);
		
		System.out.println("Its working");

	}

}
