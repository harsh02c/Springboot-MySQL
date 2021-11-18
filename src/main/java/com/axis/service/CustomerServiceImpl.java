package com.axis.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dao.ICustomerDao;
import com.axis.entity.Customer; 
@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	ICustomerDao customerdao;
	Customer pro;
	
	@Override
	public String addCustomer(Customer customer) {
		customerdao.save(customer);
		return "Customer Added";
	}

	@Override
	public List<Customer> viewAllCustomer() {
		// TODO Auto-generated method stub
		 return customerdao.findAll();
	}

	@Override
	public Customer viewCustomerById(int id) throws NoSuchElementException {		
			return customerdao.findById(id).get(); // get() will return the value if present else throw NoSuchElementException
	}

	@Override
	public String deleteCustomerById(int id){
		try {
			customerdao.deleteById(id);
			return "Customer Deleted";
		}catch(Exception e) {
			return "No Data is present at this "+id+" id";
		}
	}



	@Override
	public String updateCustomerById(int id, Customer customer) {
		try {
			customerdao.findById(id).get();
			customerdao.deleteById(id);
			customerdao.save(customer);
			return "Customer Updated";
			
		}catch(NoSuchElementException e) {
			customerdao.save(customer);
			return "No Element found by "+id+" id. but given customer is add to "+id+" id";
		}
	}

}
