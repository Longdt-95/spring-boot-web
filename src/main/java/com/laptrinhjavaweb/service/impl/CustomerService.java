package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.convertor.CustomerConvertor;
import com.laptrinhjavaweb.dto.AssignmentCustomerDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerConvertor customerConvertor;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<CustomerDTO> getListCustomerSearch(CustomerDTO customerDTO) {
		CustomerSearchBuilder customerSearchBuilder = customerConvertor.convertToBuilder(customerDTO);
		List<CustomerEntity> customerEntities = customerRepository.getCustomersSearch(customerSearchBuilder);
		List<CustomerDTO> result = customerEntities.stream().map(item -> customerConvertor.convertToCustomerDTO(item))
				.collect(Collectors.toList());
		return result;
	}

	@Transactional
	@Override
	public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
		CustomerEntity entity = customerConvertor.convertToCustomerEntity(customerDTO);
		CustomerDTO result;
		if (customerDTO.getId() != null) {
			CustomerEntity customerEntity = customerRepository.findOne(customerDTO.getId());
			entity.setStaffs(customerEntity.getStaffs());
			result = customerConvertor.convertToCustomerDTO(customerRepository.save(entity));
			return result;
		} else {
			result = customerConvertor.convertToCustomerDTO(customerRepository.save(entity));
			return result;
		}
	}

	@Override
	public CustomerDTO findById(long customerId) {
		CustomerDTO customerDTO = customerConvertor.convertToCustomerDTO(customerRepository.findOne(customerId));
		return customerDTO;
	}

	@Override
	public void delCustomers(long[] customerIds) {
		for (long customerId : customerIds) {
			customerRepository.delete(customerId);
		}
	}


	@Override
	public void assignmentCustomer(AssignmentCustomerDTO assignmentCustomerDTO) {
		CustomerEntity customerEntity = customerRepository.findOne(assignmentCustomerDTO.getCustomerId());
		List<UserEntity> staffs = new ArrayList<>();
		for (long staffId : assignmentCustomerDTO.getStaffIds()) {
			UserEntity userEntity = userRepository.findOne(staffId);
			staffs.add(userEntity);
		}
		customerEntity.setStaffs(staffs);
		customerRepository.save(customerEntity);
	}
		

}
