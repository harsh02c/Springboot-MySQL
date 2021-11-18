package com.axis.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	private int id;
	private String name;
	private String email;
	private String mobile;
	private int age;

	// Default Constructor
	public Customer() {
		super();
	}
	
	public Customer(int id, String name, String email, String mobile, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", age=" + age
				+ "]";
	}
	
}
