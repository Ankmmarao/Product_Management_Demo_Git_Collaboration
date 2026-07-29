package com.iispl.main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.iispl.entity.Product;
import com.iispl.service.ProductServiceIMPL;
import com.iispl.service.ProductServices;

public class ProductUtility {

    private static ProductServices productServices = new ProductServiceIMPL();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n1. Save Product");
            System.out.println("2. Display Products");
            System.out.println("3. Search Product By Name");
            System.out.println("4. Update Product Name By ID");
            System.out.println("5. Delete Product By ID");
            System.out.println("6. Exit");

            System.out.println("Enter Operation");
            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    saveProduct();
                    break;

                

                case 2:
                	System.out.println("Enter the Product ID:");
                	String id=input.next();
                    getProduct(id);
                    break;

                case 3:
                	System.out.println("Enter Product Code");
                    String code = input.next();

                    System.out.println("Enter Product Name");
                    String name = input.next();
                    
                    updateProduct(code,name);
                    break;

                case 4:
                	System.out.println("Enter the product code: ");
                	String productCode=input.next();
                    deleteProduct(productCode);
                    break;

                case 5:
                    System.out.println("Application Closed");
                    System.exit(0);

                default:
                    System.out.println("Invalid Operation");
            }
        }
    }

    private static void getProduct(String productCode) {
    	productServices.getProduct(productCode);
	}


	private static void saveProduct() {

        System.out.println("Enter Product Code");
        String code = input.next();

        System.out.println("Enter Product Name");
        String name = input.next();

        System.out.println("Enter Description");
        String description = input.next();

        System.out.println("Enter Activation Date (yyyy-MM-dd)");
        LocalDate activationDate = LocalDate.parse(input.next());

        System.out.println("Enter Expiry Date (yyyy-MM-dd)");
        LocalDate expiryDate = LocalDate.parse(input.next());


        Product product = new Product(
                code,
                name,
                description,
                activationDate,
                expiryDate
        );

        productServices.createProduct(product);

    }


   

   
    private static void deleteProduct(String productCode) {
    	
    	productServices.deleteProduct(productCode);
    	
    }


    private static void updateProduct(String code,String name) {
    	
        productServices.updateProduct(code,name);
        
    }
}