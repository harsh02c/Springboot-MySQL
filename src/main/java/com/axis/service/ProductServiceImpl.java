package com.axis.service;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dao.IProductDao;
import com.axis.entity.Product;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	IProductDao productdao;
	Product pro;
	
	@Override
	public String addProduct(Product product) {
		productdao.save(product);
		return "Product Added";
	}

	@Override
	public List<Product> viewAllProduct() {
		return productdao.findAll();
	}

	@Override
	public Product viewProductById(int id) throws NoSuchElementException {		
			return productdao.findById(id).get(); // get() will return the value if present else throw NoSuchElementException
	}

	@Override
	public String deleteProductById(int id){
		try {
			productdao.deleteById(id);
			return "Product Deleted";
		}catch(Exception e) {
			return "No Data is present at this "+id+" id";
		}
	}

	@Override
	public String updateProductById(int id, Product product) {
		try {
			productdao.findById(id).get();
			productdao.deleteById(id);
			productdao.save(product);
			return "Product Updated";
			
		}catch(NoSuchElementException e) {
			productdao.save(product);
			return "No Element found by "+id+" id. but given product is add to "+id+" id";
		}
	}
	
	 
}
