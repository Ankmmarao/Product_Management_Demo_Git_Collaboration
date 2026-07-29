package com.iispl.dao;

import java.util.List;

import com.iispl.entity.Product;

public interface ProductDao {
	
	public void createProduct(Product product);

	public Product getProduct(String productCode);
	
}
