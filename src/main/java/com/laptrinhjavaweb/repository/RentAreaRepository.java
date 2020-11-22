package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laptrinhjavaweb.entity.RentAreaEntity;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long>{
	List<RentAreaEntity> findBybuildingId(long buildingId);
	@Modifying
	@Query(nativeQuery = true, value = "DELETE From rentarea WHERE buildingid = :buildingId")
	void deleteBybuilding(@Param("buildingId") long buildingId);
}
