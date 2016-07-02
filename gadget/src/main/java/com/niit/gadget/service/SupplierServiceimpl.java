package com.niit.gadget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.gadget.dao.SupplierDAO;
import com.niit.gadget.Model.SupplierModel;

@Service
public class SupplierServiceimpl implements SupplierService{
	@Autowired
	SupplierDAO SupplierDAO;
	public void insertSupplierModel(SupplierModel u)
	{
		SupplierDAO.insertSupplierModel(u);
	}
	
}
