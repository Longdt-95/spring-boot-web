package com.laptrinhjavaweb.convertor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.builder.CustomerSearchBuilder.builderCustomer;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;

@Component
public class CustomerConvertor {

	ModelMapper modelMapper = new ModelMapper();

	public CustomerDTO convertToCustomerDTO(CustomerEntity customerEntity) {
		CustomerDTO customerDTO = modelMapper.map(customerEntity, CustomerDTO.class);
		return customerDTO;
	}

	public CustomerEntity convertToCustomerEntity(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = modelMapper.map(customerDTO, CustomerEntity.class);
		return customerEntity;
	}
	
	public CustomerSearchBuilder convertToBuilder(CustomerDTO customerDTO) {
		CustomerSearchBuilder builder = modelMapper.map(customerDTO, builderCustomer.class).build();
		return builder;
	}
}
