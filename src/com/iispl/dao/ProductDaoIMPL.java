package com.iispl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.iispl.connectionpool.ConnectionPool;
import com.iispl.entity.Product;

public class ProductDaoIMPL implements ProductDao {


	@Override
	public void createProduct(Product product) {
	
		// TODO Auto-generated method stub
        String selectQuery = "INSERT INTO Product(productcode,product_name,product_description,activation_date,expiry_date) values(?,?,?,?,?)";

		try {
			DataSource ds = ConnectionPool.getDataSource();
			Connection connection = ds.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(selectQuery);
			pstmt.setString(1, product.getProductcode());
			pstmt.setString(2, product.getProductName());
			pstmt.setString(3, product.getProductdescription());
			pstmt.setObject(4, product.getActivationDate());
			pstmt.setObject(5, product.getExpiryDate());
			int result=pstmt.executeUpdate();
			if(result>0) {
				System.out.println("Product Addesd SUccesfully");
			}
			
		}
		catch(Exception e) {
			
		}
		
	}

	
	
		

	
}