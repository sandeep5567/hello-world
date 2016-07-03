
package com.niit.gadget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.gadget.Model.CategoryModel;
import com.niit.gadget.Model.ProductModel;
import com.niit.gadget.Model.SignupModel;
import com.niit.gadget.Model.SupplierModel;
import com.niit.gadget.service.CategoryService;
import com.niit.gadget.service.UserService;

import antlr.collections.List;

import com.niit.gadget.service.SupplierService;
import com.niit.gadget.service.ProductService;
@Controller
public class HomeController {
	@Autowired
	UserService us;
	@Autowired
	CategoryService cs;
	@Autowired
	SupplierService ss;
	  @Autowired
		ProductService ps;
	
	@RequestMapping("/")
	public ModelAndView getHomePage() {

	
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}
	@RequestMapping("/signup")
	public ModelAndView signup() {
        //us.insertSignupModel(sm);
		
		return new ModelAndView("signup","command",new SignupModel());
	}
	
	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer(@ModelAttribute("SignupModel") SignupModel sm ) {
	System.out.println("in add customer");
        us.insertSignupModel(sm);
		
		ModelAndView mv=new ModelAndView("signup","command",new SignupModel());
		return mv;
	}



		
	@RequestMapping("/login")
	public ModelAndView login() {

		
		ModelAndView mv=new ModelAndView("login");
		return mv;
	}
	@RequestMapping("/categories")
	public ModelAndView categories() {

		
		ModelAndView mv=new ModelAndView("category","command",new CategoryModel());
		return mv;
	}
	@RequestMapping("/addcategory")
	public ModelAndView addCategory(@ModelAttribute("CategoryModel") CategoryModel c ) {
	System.out.println("in add category");
        cs.insertCategoryModel(c);
		
		ModelAndView mv=new ModelAndView("category","command",new CategoryModel());
		return mv;
	}
	@RequestMapping("/suppliers")
	public ModelAndView suppliers() {

		
		ModelAndView mv=new ModelAndView("supplier","command",new SupplierModel());
		return mv;
	}
	@RequestMapping("/addsupplier")
	public ModelAndView addSupplier(@ModelAttribute("SupplierModel") SupplierModel c ) {
	System.out.println("in add supplier");
        ss.insertSupplierModel(c);
		
		ModelAndView mv=new ModelAndView("supplier","command",new SupplierModel());
		return mv;
	}
	@RequestMapping("/Products")
	public ModelAndView product() {

		return new ModelAndView("product","command",new ProductModel());
	}
	@RequestMapping("/addproduct")
	public ModelAndView addProduct(@ModelAttribute("ProductModel") ProductModel pm ) {
	System.out.println("in add product");
	    ps.insertProductModel(pm);		
		ModelAndView mv=new ModelAndView("product","command",new ProductModel());
		return mv;
	}
	@RequestMapping("/viewproduct")
	public ModelAndView viewproducts()
	{
		java.util.List<ProductModel> arr=ps.getProductList();
		Gson gson=new Gson();
		String json=gson.toJson(arr);
		return new ModelAndView("productslist","data",gson.toJson(arr));
	}
	@RequestMapping("/customercare")
	public ModelAndView customercare() {

		
		ModelAndView mv=new ModelAndView("customercare");
		return mv;
	}
	
	
@RequestMapping("/adminhome")
public ModelAndView adminhome(){
ModelAndView mv= new ModelAndView("adminhome");
return mv;
}

}