package com.niit.gadget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.gadget.dao.CategoryDAO;
import com.niit.gadget.Model.CategoryModel;

@Service
public class CategoryServiceimpl implements CategoryService{
	@Autowired
	CategoryDAO CategoryDAO;
	public void insertCategoryModel(CategoryModel u)
	{
		CategoryDAO.insertCategoryModel(u);
	}
	

}
