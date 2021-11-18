package com.axis.service;

import java.util.List;

import com.axis.entity.Product;

public interface IProductService {

	String addProduct(Product product);
	List<Product> viewAllProduct();
	Product viewProductById(int id);
	String deleteProductById(int id);
	String updateProductById(int id, Product product);
}
