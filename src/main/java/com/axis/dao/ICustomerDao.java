package com.axis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.axis.entity.Customer;
@Repository		// it will fine if we don't want to decorate it with @Repository
public interface ICustomerDao extends JpaRepository<Customer, Integer>{

}
