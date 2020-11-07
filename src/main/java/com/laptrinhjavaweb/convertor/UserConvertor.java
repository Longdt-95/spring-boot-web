package com.laptrinhjavaweb.convertor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

@Component
public class UserConvertor {
	
	ModelMapper modelMapper = new ModelMapper();

	public UserDTO convertToUserDTO(UserEntity userEntity) {
		UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
		return userDTO;
	}

	public UserEntity convertToUserEntity(UserDTO userDTO) {
		UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
		return userEntity;
	}
}
