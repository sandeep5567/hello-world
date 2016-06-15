package com.niit.ShoppingCart1.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
context.scan("com.niit.ShoppingCart1.bean");
context.refresh();
	}

}
