package com.iispl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

            try (Connection connection = ds.getConnection();
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
}