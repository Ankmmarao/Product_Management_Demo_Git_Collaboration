package com.iispl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.iispl.connectionpool.ConnectionPool;
import com.iispl.entity.Product;

public class ProductDaoIMPL implements ProductDao {

    @Override
    public void createProduct(Product product) {

        String insertQuery = 
            "INSERT INTO \"Product\" " +
            "(productcode, productName, productdescription, activationDate, expiryDate) " +
            "VALUES (?, ?, ?, ?, ?)";

        try {
            DataSource ds = ConnectionPool.getDataSource();

            try (
            	Connection connection = ds.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {

                pstmt.setString(1, product.getProductcode());
                pstmt.setString(2, product.getProductName());
                pstmt.setString(3, product.getProductdescription());
                pstmt.setObject(4, product.getActivationDate());
                pstmt.setObject(5, product.getExpiryDate());

                int result = pstmt.executeUpdate();

                if (result > 0) {
                    System.out.println("Product Added Successfully");
                } else {
                    System.out.println("Product Not Added");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public void deleteProduct(String productCode) {
		String deleteQuery ="delete from product where productCode=?"; 
		try {
            DataSource ds = ConnectionPool.getDataSource();
    
            try {
            	Connection connection = ds.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(deleteQuery) ;
                pstmt.setString(1,productCode);
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Product deleted successfully.");
                } else {
                    System.out.println("No product found with code: " + productCode);
                }

            } catch (SQLException se) {
                se.printStackTrace();
            }
		
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
}