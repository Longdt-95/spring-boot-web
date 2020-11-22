package com.laptrinhjavaweb.repository.custom;

import java.util.List;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.CustomerEntity;

public interface CustomerRepositoryCustom {

	List<CustomerEntity> getCustomersSearch(CustomerSearchBuilder customerSearchBuilder);
}
