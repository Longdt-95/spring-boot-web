package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.convertor.UserConvertor;
import com.laptrinhjavaweb.dto.UserDTO;
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
}
