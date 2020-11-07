package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.BuildingEntity;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>{
	
	List<BuildingEntity> findAll();
		
}
