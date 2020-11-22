package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity{

	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name ="assignmentcustomer", joinColumns = @JoinColumn (name="customerid")
		, inverseJoinColumns = @JoinColumn (name = "staffid"))
	private List<UserEntity> staffs = new ArrayList<>();
	
	
	public List<UserEntity> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<UserEntity> staffs) {
		this.staffs = staffs;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
