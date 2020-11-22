package com.laptrinhjavaweb.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.AssignmentCustomerDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.service.impl.CustomerService;

@RestController (value = "CustomerAPIOfAdmin")
public class CustomerAPI {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private IUserService userService;

	@PostMapping("/api/customer")
	public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
		return customerService.saveCustomer(customerDTO);
	}
	
	@DeleteMapping("/api/customer-del")
	public void delCustomer(@RequestBody long[] customerIds) {
		customerService.delCustomers(customerIds);
	}
	
	@GetMapping("/api/assign-customer")
	public List<UserDTO> getStaffs(@RequestParam long customerId, @RequestParam String role) {
		List<UserDTO> listResult = userService.findAllStaffAssignCustomer(customerId, role);
		return listResult;
	}
	
	@PostMapping("/api/assignment-customer")
	public void addManagerCustomer(@RequestBody AssignmentCustomerDTO assignmentCustomerDTO) {
		customerService.assignmentCustomer(assignmentCustomerDTO);
	}
}
