package com.laptrinhjavaweb.repository.Custom.IMPL;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.Custom.BuildingRepositoryCustom;

@Repository
public class BuildingRepositoryIMPL implements BuildingRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<BuildingEntity> getBuildings(BuildingSearchBuilder buildingSearchBuilder) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building b");
		if (buildingSearchBuilder.getstaffId() != null && buildingSearchBuilder.getstaffId() != -1) {
			sql.append(" JOIN assignmentbuilding a on b.id = a.buildingid");
		}
		sql.append(" WHERE 1 = 1");
		sql = buildSQLBuildingSearchCommon(buildingSearchBuilder, sql);
		sql = buildSQLBuiSearchSpecial(buildingSearchBuilder, sql);
		if (buildingSearchBuilder.getstaffId() != null && buildingSearchBuilder.getstaffId() != -1) {
			sql.append(" AND a.staffid = " + buildingSearchBuilder.getstaffId());
		}
		Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
		return query.getResultList();

	}

	private StringBuilder buildSQLBuiSearchSpecial(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		if (buildingSearchBuilder.getRentPriceFrom() != null) {
			sql.append(" AND b.rentprice >= " + buildingSearchBuilder.getRentPriceFrom());
		}
		if (buildingSearchBuilder.getRentPriceTo() != null) {
			sql.append(" AND b.rentprice <= " + buildingSearchBuilder.getRentPriceTo());
		}
		if (buildingSearchBuilder.getRentAreaFrom() != null || buildingSearchBuilder.getRentAreaTo() != null) {
			sql.append(" AND EXISTS (SELECT * FROM rentarea r WHERE r.buildingid = b.id");
			if (buildingSearchBuilder.getRentAreaFrom() != null) {
				sql.append(" AND r.value >= " + buildingSearchBuilder.getRentAreaFrom());
			}
			if (buildingSearchBuilder.getRentAreaTo() != null) {
				sql.append(" AND r.value <= " + buildingSearchBuilder.getRentAreaTo());
			}
			sql.append(" )");
		}
		if (buildingSearchBuilder.getTypes() != null && buildingSearchBuilder.getTypes().length > 0) {
			sql.append(" AND (");
			String sqlType = Arrays.stream(buildingSearchBuilder.getTypes()).map(item -> "b.type LIKE '%" + item + "%'")
					.collect(Collectors.joining(" OR "));
			sql.append(sqlType);
			sql.append(")");
		}

		return sql;
	}

	private StringBuilder buildSQLBuildingSearchCommon(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				if (!field.getName().startsWith("rentPrice") && !field.getName().startsWith("rentArea")
						&& !field.getName().equals("types") && !field.getName().equals("staffId")) {
					if (field.getType().getName().equals("java.lang.String")) {
						if (field.get(buildingSearchBuilder) != null) {
							sql.append(" and b." + field.getName().toLowerCase() + " like '%"
									+ field.get(buildingSearchBuilder) + "%'");
						}
					} else if (field.getType().getName().equals("java.lang.Integer")) {
						if (field.get(buildingSearchBuilder) != null) {
							sql.append(" and b." + field.getName().toLowerCase() + " = "
									+ field.get(buildingSearchBuilder));
						}
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
