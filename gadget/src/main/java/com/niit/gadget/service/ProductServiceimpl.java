package com.niit.gadget.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.gadget.dao.ProductDAO;
import com.niit.gadget.Model.ProductModel;

@Service
public class ProductServiceimpl implements ProductService{
	@Autowired
	ProductDAO productDAO;
	public void insertProductModel(ProductModel u)
	{
		productDAO.insertProductModel(u);
	}
	@Override
	public List<ProductModel> getProductList() {
		// TODO Auto-generated method stub
		System.out.println("In SERVICE");
		List<ProductModel> a=productDAO.getProductList();
		System.out.println(a);
		return a;
	
	}

}
