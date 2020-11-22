package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.AssignmentCustomerDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;

public interface ICustomerService {

	List<CustomerDTO> getListCustomerSearch(CustomerDTO customerDTO);
	CustomerDTO saveCustomer(CustomerDTO customerDTO);
	CustomerDTO findById(long customerId);
	void delCustomers(long[] customerIds);
	void assignmentCustomer(AssignmentCustomerDTO assignmentCustomerDTO);
}
