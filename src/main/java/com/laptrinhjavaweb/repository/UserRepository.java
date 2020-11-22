package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laptrinhjavaweb.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByUserNameAndStatus(String name, int status);
    List<UserEntity> findByStatusAndRoles_code(int status, String roleCode);
    List<UserEntity> findByRoles_code(String roleCode);
    @Query(nativeQuery = true,value = "SELECT COUNT(*) > 0 FROM assignmentbuilding a WHERE a.staffid = :staffId AND a.buildingid = :buildingId")
    long isAssignmentBuilding(@Param("staffId")long staffId,@Param("buildingId") long buildingId);
    @Query(nativeQuery = true,value = "SELECT COUNT(*) > 0 FROM assignmentcustomer a WHERE a.staffid = :staffId AND a.customerid = :customerId")
    long isAssignmentCustomer(@Param("staffId")long staffId,@Param("customerId") long customerId);
    
}
