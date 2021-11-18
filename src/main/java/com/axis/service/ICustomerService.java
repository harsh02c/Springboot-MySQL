package com.axis.service;

import java.util.List;

import com.axis.entity.Customer;

public interface  ICustomerService{
	String addCustomer(Customer customer);
	List<Customer> viewAllCustomer();
	Customer viewCustomerById(int id);
	String deleteCustomerById(int id);
	String updateCustomerById(int id, Customer customer);
}
