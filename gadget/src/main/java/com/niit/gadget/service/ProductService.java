package com.niit.gadget.service;

import java.util.List;

import com.niit.gadget.Model.ProductModel;

public interface ProductService {
	public void insertProductModel(ProductModel u);
	List<ProductModel> getProductList();

}
