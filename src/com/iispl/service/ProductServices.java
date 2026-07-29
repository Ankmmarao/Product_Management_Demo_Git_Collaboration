package com.iispl.service;
import com.iispl.entity.*;
import java.math.*;
import java.util.List;
public interface ProductServices {

  void createProduct(Product product);

  void updateProduct(String code, String name);
  
  
}
