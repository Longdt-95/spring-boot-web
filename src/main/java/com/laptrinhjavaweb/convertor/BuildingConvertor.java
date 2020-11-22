package com.laptrinhjavaweb.convertor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.builder.BuildingSearchBuilder.BuilderBuilding;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;


@Component
public class BuildingConvertor {
	
	ModelMapper modelMapper = new ModelMapper();
	
	public BuildingDTO convertToBuildingDTO(BuildingEntity buildingEntity) {
		BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);
		return buildingDTO;
	}

	public BuildingEntity convertToBuildingEntity(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);
		return buildingEntity;
	}
	
	public BuildingSearchBuilder convertToBuilder(BuildingDTO buildingDTO) {
		BuildingSearchBuilder builder = modelMapper.map(buildingDTO, BuilderBuilding.class).build();
		return builder;
	}
	
}
