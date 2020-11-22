package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.convertor.UserConvertor;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConvertor userConvertor;

    @Override
    public UserDTO findOneByUserNameAndStatus(String name, int status) {
        return userConvertor.convertToUserDTO(userRepository.findOneByUserNameAndStatus(name, status));
    }

	@Override
	public Map<Long, String> getStaffMaps() {
		Map<Long, String> result = new HashMap<>();
		List<UserEntity> listUserEntitys = userRepository.findByStatusAndRoles_code(1, "STAFF");
		for (UserEntity userEntity : listUserEntitys) {
			result.put(userEntity.getId(), userEntity.getFullName());
		}
		return result;
	}

	@Override
	public List<UserDTO> findAllStaffAssignBuilding(long buildingId, String role) {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setId(buildingId);
		List<UserEntity> staffs = userRepository.findByRoles_code(role);
		List<UserDTO> result = staffs.stream().map(item -> {
			UserDTO userDTO = userConvertor.convertToUserDTO(item);
			long flag = userRepository.isAssignmentBuilding(userDTO.getId(), buildingId);
			if (flag > 0) {
				userDTO.setChecked("checked");
			}
			return userDTO;
		}).collect(Collectors.toList());
		return result;
	}

	@Override
	public List<UserDTO> findAllStaffAssignCustomer(long customerId, String role) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setId(customerId);
		List<UserEntity> staffs = userRepository.findByRoles_code(role);
		List<UserDTO> result = staffs.stream().map(item -> {
			UserDTO userDTO = userConvertor.convertToUserDTO(item);
			long flag = userRepository.isAssignmentCustomer(userDTO.getId(), customerId);
			if (flag > 0) {
				userDTO.setChecked("checked");
			}
			return userDTO;
		}).collect(Collectors.toList());
		return result;
	}
}
