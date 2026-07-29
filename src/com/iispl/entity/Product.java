package com.iispl.entity;

import java.time.LocalDate;

public class Product {
     private String productcode;
     private String productName;
     private String productdescription;
     private LocalDate activationDate;
     private LocalDate expiryDate;
	 public Product(String productcode, String productName, String productdescription, LocalDate activationDate,
			LocalDate expiryDate) {
		super();
		this.productcode = productcode;
		this.productName = productName;
		this.productdescription = productdescription;
		this.activationDate = activationDate;
		this.expiryDate = expiryDate;
	 }
	 public String getProductcode() {
		 return productcode;
	 }
	 public void setProductcode(String productcode) {
		 this.productcode = productcode;
	 }
	 public String getProductName() {
		 return productName;
	 }
	 public void setProductName(String productName) {
		 this.productName = productName;
	 }
	 public String getProductdescription() {
		 return productdescription;
	 }
	 public void setProductdescription(String productdescription) {
		 this.productdescription = productdescription;
	 }
	 public LocalDate getActivationDate() {
		 return activationDate;
	 }
	 public void setActivationDate(LocalDate activationDate) {
		 this.activationDate = activationDate;
	 }
	 public LocalDate getExpiryDate() {
		 return expiryDate;
	 }
	 public void setExpiryDate(LocalDate expiryDate) {
		 this.expiryDate = expiryDate;
	 }
}
