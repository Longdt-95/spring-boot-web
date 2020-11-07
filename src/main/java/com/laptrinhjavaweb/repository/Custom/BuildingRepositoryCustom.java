package com.laptrinhjavaweb.repository.Custom;

import java.util.List;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;

public interface BuildingRepositoryCustom {
	
	List<BuildingEntity> getBuildings(BuildingSearchBuilder buildingSearchBuilder);
}
