package com.iispl.service;

import java.util.List;

import com.iispl.entity.Product;
import com.iispl.dao.*;
public class ProductServiceIMPL implements ProductServices {

	
	ProductDao productdao=new ProductDaoIMPL();
	
	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		
		productdao.createProduct(new Product(product.getProductcode(),product.getProductName(),product.getProductdescription(),product.getActivationDate(),product.getExpiryDate()));
	}

	
	public Product getProduct(String productCode) {
		return productdao.getProduct(productCode);
	}

	public void updateProduct(String code, String name) {
		// TODO Auto-generated method stub
		productdao.updateProduct(code,name);

	}
	
	
	

}
