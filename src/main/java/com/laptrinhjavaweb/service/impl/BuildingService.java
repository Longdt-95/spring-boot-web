package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.convertor.BuildingConvertor;
import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.enums.BuildingTypeEnum;
import com.laptrinhjavaweb.enums.DistrictEnum;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IBuildingService;

@Service
public class BuildingService implements IBuildingService {

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private BuildingConvertor buildingConvertor;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<BuildingDTO> getBuildings(BuildingDTO buildingDTO) {
		BuildingSearchBuilder buildingSearchBuilder = buildingConvertor.convertToBuilder(buildingDTO);
		List<BuildingEntity> buildingEntities = buildingRepository.getBuildings(buildingSearchBuilder);
		List<BuildingDTO> result = buildingEntities.stream().map(item -> buildingConvertor.convertToBuildingDTO(item))
				.collect(Collectors.toList());
		for (int i = 0; i < buildingEntities.size(); i++) {
			String rentArea = buildingEntities.get(i).getRentAres().stream().map(item -> item.getValue().toString())
					.collect(Collectors.joining(","));
			result.get(i).setRentArea(rentArea);
			result.get(i).setDistrict(DistrictEnum.valueOf(result.get(i).getDistrict()).getValue());
			result.get(i).setTypes(result.get(i).getType().split(","));
		}
		for (BuildingDTO dto : result) {
			dto.setAddress(dto.getStreet() + "-" + dto.getWard() + "-" + dto.getDistrict());
		}
		return result;
	}


	@Override
	public Map<String, String> getBuildingTypes() {
		Map<String, String> result = new HashMap<>();
		for (BuildingTypeEnum buildingType : BuildingTypeEnum.values()) {
			result.put(buildingType.name(), buildingType.getValue());
		}
		return result;

	}

	@Override
	public List<BuildingDTO> getBuildings(Map<String, String> requestParams, String[] type) {
		BuildingSearchBuilder builder = convertMapToBuilder(requestParams, type);
		List<BuildingEntity> listBuildingEntitie = buildingRepository.getBuildings(builder);
		List<BuildingDTO> result = listBuildingEntitie.stream()
				.map(item -> buildingConvertor.convertToBuildingDTO(item)).collect(Collectors.toList());
		for (int i = 0; i < listBuildingEntitie.size(); i++) {
			String rentArea = listBuildingEntitie.get(i).getRentAres().stream().map(item -> item.getValue().toString())
					.collect(Collectors.joining(","));
			result.get(i).setRentArea(rentArea);
			result.get(i).setDistrict(DistrictEnum.valueOf(result.get(i).getDistrict()).getValue());
			result.get(i).setTypes(result.get(i).getType().split(","));
		}
		for (BuildingDTO dto : result) {
			dto.setAddress(dto.getStreet() + "-" + dto.getWard() + "-" + dto.getDistrict());
		}
		return result;
	}

	private BuildingSearchBuilder convertMapToBuilder(Map<String, String> requestParams, String[] type) {
		Integer numberOfBasement = requestParams.containsKey("numberOfBasement")
				? (StringUtils.isNoneBlank(requestParams.get("numberOfBasement"))
						? Integer.parseInt(requestParams.get("numberOfBasement"))
						: null)
				: null;
		Integer floorarea = requestParams.containsKey("floorarea")
				? (StringUtils.isNoneBlank(requestParams.get("floorarea"))
						? Integer.parseInt(requestParams.get("floorarea"))
						: null)
				: null;
		Integer rentAreaFrom = requestParams.containsKey("rentAreaFrom")
				? (StringUtils.isNoneBlank(requestParams.get("rentAreaFrom"))
						? Integer.parseInt(requestParams.get("rentAreaFrom"))
						: null)
				: null;
		Integer rentAreaTo = requestParams.containsKey("rentAreaTo")
				? (StringUtils.isNoneBlank(requestParams.get("rentAreaTo"))
						? Integer.parseInt(requestParams.get("rentAreaTo"))
						: null)
				: null;
		Integer rentPriceFrom = requestParams.containsKey("rentPriceFrom")
				? (StringUtils.isNoneBlank(requestParams.get("rentPriceFrom"))
						? Integer.parseInt(requestParams.get("rentPriceFrom"))
						: null)
				: null;
		Integer rentPriceTo = requestParams.containsKey("rentPriceTo")
				? (StringUtils.isNoneBlank(requestParams.get("rentPriceTo"))
						? Integer.parseInt(requestParams.get("rentPriceTo"))
						: null)
				: null;
		Long staffId = requestParams.containsKey("staffId")
				? (StringUtils.isNoneBlank(requestParams.get("staffId")) ? Long.parseLong(requestParams.get("staffId"))
						: null)
				: null;

		BuildingSearchBuilder builder = new BuildingSearchBuilder.BuilderBuilding()
				.setName(requestParams.containsKey("name") ? requestParams.get("name") : null)
				.setNumberOfBasement(numberOfBasement)
				.setDirection(requestParams.containsKey("direction") ? requestParams.get("direction") : null)
				.setDistrict(requestParams.containsKey("district") ? requestParams.get("district") : null)
				.setFloorArea(floorarea)
				.setStreet(requestParams.containsKey("street") ? requestParams.get("street") : null)
				.setLevel(requestParams.containsKey("level") ? requestParams.get("level") : null)
				.setWard(requestParams.containsKey("ward") ? requestParams.get("ward") : null)
				.setRentAreaFrom(rentAreaFrom).setRentAreaTo(rentAreaTo).setRentPriceFrom(rentPriceFrom)
				.setRentPriceTo(rentPriceTo)
				.setManagerName(requestParams.containsKey("managerName") ? requestParams.get("managerName") : null)
				.setManagerPhone(requestParams.containsKey("managerPhone") ? requestParams.get("managerPhone") : null)
				.setStaffId(staffId).setTypes(type).build();
		return builder;
	}

	@Transactional
	@Override
	public BuildingDTO saveBuilding(BuildingDTO buildingDTO) {
		BuildingDTO result;
		BuildingEntity entity = buildingConvertor.convertToBuildingEntity(buildingDTO);
		entity.setType(String.join(",", buildingDTO.getTypes()));
		List<RentAreaEntity> areaEntities = new ArrayList<>();
		if(!buildingDTO.getRentArea().isEmpty()) {
			String[] rentAreas = buildingDTO.getRentArea().split(",");
			for (String str : rentAreas) {
				RentAreaEntity rentAreaEntity = new RentAreaEntity();
				rentAreaEntity.setBuilding(entity);
				rentAreaEntity.setValue(Integer.parseInt(str));
				areaEntities.add(rentAreaEntity);
			}
		}
		if (buildingDTO.getId() != null) {
			BuildingEntity buildingEntity = buildingRepository.findOne(buildingDTO.getId());
			entity.setStaffs(buildingEntity.getStaffs());
			entity.setRentAres(areaEntities);
			result = buildingConvertor.convertToBuildingDTO(buildingRepository.save(entity));
			return result;
		} else {
			entity.setRentAres(areaEntities);
			result = buildingConvertor.convertToBuildingDTO(buildingRepository.save(entity));
			return result;
		}
	}

	@Override
	public BuildingDTO findById(long id) {
		BuildingEntity entity = buildingRepository.findOne(id);
		BuildingDTO result = buildingConvertor.convertToBuildingDTO(entity);
		String rentArea = entity.getRentAres().stream().map(item -> item.getValue().toString())
				.collect(Collectors.joining(","));
		result.setRentArea(rentArea);
		String staffId = entity.getStaffs().stream().map(item -> item.getId().toString())
				.collect(Collectors.joining(","));
		result.setStaffId(staffId);
	//	result.setDistrict(DistrictEnum.valueOf(entity.getDistrict()).getValue());
		result.setAddress(result.getStreet() + "-" + result.getWard() + "-" + result.getDistrict());
		result.setTypes(result.getType().split(","));
		return result;
	}

	@Transactional
	@Override
	public void delBuilding(long[] buildingIds) {
		for (long buildingId : buildingIds) {
			buildingRepository.delete(buildingId);
		}
	}

	@Override
	public void assignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO) {
		BuildingEntity buildingEntity = buildingRepository.findOne(assignmentBuildingDTO.getBuildingId());
		List<UserEntity> staffs = new ArrayList<>();
		for (long staffId : assignmentBuildingDTO.getStaffIds()) {
			UserEntity userEntity = userRepository.findOne(staffId);
			staffs.add(userEntity);
		}
		buildingEntity.setStaffs(staffs);
		buildingRepository.save(buildingEntity);
	}
}
