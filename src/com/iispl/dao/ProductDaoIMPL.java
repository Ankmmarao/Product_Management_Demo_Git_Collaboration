package com.iispl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


import java.sql.ResultSet;


import java.sql.SQLException;

import javax.sql.DataSource;

import com.iispl.connectionpool.ConnectionPool;
import com.iispl.entity.Product;

public class ProductDaoIMPL implements ProductDao {

    @Override
    public void createProduct(Product product) {

        String insertQuery = "INSERT INTO \"Product\" "
                + "(productcode, productName, productdescription, activationDate, expiryDate) "
                + "VALUES (?, ?, ?, ?, ?)";

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
    public Product getProduct(String productCode) {

        Product product = null;

        String selectQuery = "SELECT * FROM \"Product\" WHERE productcode = ?";

        try {

            DataSource ds = ConnectionPool.getDataSource();

            try (Connection connection = ds.getConnection();
                 PreparedStatement pstmt = connection.prepareStatement(selectQuery)) {


                pstmt.setString(1, productCode);

                ResultSet resultSet = pstmt.executeQuery();


                if (resultSet.next()) {

                    product = new Product(
                            resultSet.getString("productcode"),
                            resultSet.getString("productName"),
                            resultSet.getString("productdescription"),
                            resultSet.getDate("activationDate").toLocalDate(),
                            resultSet.getDate("expiryDate").toLocalDate()
                    );


                    System.out.println("Product Code      : " + product.getProductcode());
                    System.out.println("Product Name      : " + product.getProductName());
                    System.out.println("Product Description: " + product.getProductdescription());
                    System.out.println("Activation Date   : " + product.getActivationDate());
                    System.out.println("Expiry Date       : " + product.getExpiryDate());

                } else {

                    System.out.println("Product Not Found");

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return product;
    }

	@Override
	public void updateProduct(String code, String name) {
		// TODO Auto-generated method stub
		Connection connection = null;
		String updateSQL="update Product set productName = ? where productcode = ?";
		PreparedStatement prepStmt=null;
		try {
			DataSource ds=ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt=connection.prepareStatement(updateSQL);
			prepStmt.setString(1, name);
			prepStmt.setString(2, code);
			int rows = prepStmt.executeUpdate();
			if(rows>0) {
				System.out.println(rows+" updated");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		    try {
		        if (connection != null) {
		            connection.close();
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
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