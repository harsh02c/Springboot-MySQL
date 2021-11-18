package com.axis.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.axis.entity.Product;
import com.axis.entity.Customer;
import com.axis.exception.IDNotFoundException;
import com.axis.service.ICustomerService; 

@RestController
@RequestMapping(value = "/productControllerWithException")
public class CustomerController {
	
	@Autowired
	ICustomerService customerservice;
	
	
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping(value = "/addNewCustomer")
	public ResponseEntity<String> addNewCustomer(@RequestBody Customer customer) {	
		// @RequestBody helps to take data from the user
		return new ResponseEntity<String>(customerservice.addCustomer(customer), HttpStatus.OK);		
	}
	
	@GetMapping(value = "/viewAllCustomer")
	public ResponseEntity<List<Customer>> viewAllCustomer(){
		return new ResponseEntity<List<Customer>>(customerservice.viewAllCustomer(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/viewCustomerById/{id}")
	public ResponseEntity<Object> viewProductById(@PathVariable int id){	
		//@PathVariable is used if you want to find element by passing parameter inside path
//		return new ResponseEntity<Product>(productservice.viewProductById(id), HttpStatus.OK);
		try {
			return new ResponseEntity<Object>(customerservice.viewCustomerById(id), HttpStatus.OK);
		}catch(NoSuchElementException e) {
			throw new IDNotFoundException("no id present for view");
		}
		
		
	}
	
	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
		return new ResponseEntity<String>(customerservice.deleteCustomerById(id), HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateProductById/{id}")
	public ResponseEntity<String> updateProductById(@PathVariable int id, @RequestBody Customer customer){
		return new ResponseEntity<String>(customerservice.updateCustomerById(id, customer), HttpStatus.OK);
		
	}
	/*
	@ExceptionHandler(value = IDNotFoundException.class)
	public ResponseEntity<Object> myEmployeeIdException(IDNotFoundException exception){
		return new ResponseEntity<Object>(exception.getMsg(),HttpStatus.NOT_FOUND);
	}*/
	
}
