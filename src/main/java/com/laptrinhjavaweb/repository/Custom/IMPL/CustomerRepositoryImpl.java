package com.laptrinhjavaweb.repository.custom.impl;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public List<CustomerEntity> getCustomersSearch(CustomerSearchBuilder customerSearchBuilder) {
		StringBuilder sql = new StringBuilder("SELECT * FROM customer c");
		if (customerSearchBuilder.getStaffId() != null && customerSearchBuilder.getStaffId() != -1) {
			sql.append(" JOIN assignmentcustomer a on c.id = a.customerid");
		}
		sql.append(" WHERE 1 = 1");
		sql = buildSQLCustomerSearchCommon(customerSearchBuilder, sql);
		if (customerSearchBuilder.getStaffId() != null && customerSearchBuilder.getStaffId() != -1) {
			sql.append(" AND a.staffid = " + customerSearchBuilder.getStaffId());
		}
		Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
		return query.getResultList();
	}
	
	private StringBuilder buildSQLCustomerSearchCommon(CustomerSearchBuilder customerSearchBuilder, StringBuilder sql) {
		Field[] fields = CustomerSearchBuilder.class.getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
					if (field.getType().getName().equals("java.lang.String")) {
						if (field.get(customerSearchBuilder) != null && !field.get(customerSearchBuilder).toString().isEmpty()) {
							sql.append(" and c." + field.getName().toLowerCase() + " like '%"
									+ field.get(customerSearchBuilder) + "%'");
						}
					} else if (field.getType().getName().equals("java.lang.Integer")) {
						if (field.get(customerSearchBuilder) != null && !field.get(customerSearchBuilder).toString().isEmpty()) {
							sql.append(" and c." + field.getName().toLowerCase() + " = "
									+ field.get(customerSearchBuilder));
						}
					}
				}
			return sql;
		} catch (IllegalArgumentException | IllegalAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
