package com.niit.gadget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.gadget.dao.UserDAO;
import com.niit.gadget.model.SignupModel;

@Service
public class UserServiceimpl implements UserService{
	@Autowired
	UserDAO userDAO;
	public void insertSignupModel(SignupModel u)
	{
		userDAO.insertSignupModel(u);
	}
	

}
