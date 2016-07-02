package com.niit.gadget.dao;

import java.util.List;

import com.niit.gadget.Model.ProductModel;

public interface ProductDAO {
	public void insertProductModel(ProductModel u);

	public List<ProductModel> getProductList();

}
