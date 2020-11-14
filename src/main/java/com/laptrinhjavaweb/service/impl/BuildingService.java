package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.builder.BuildingSearchBuilder.BuilderBuilding;
import com.laptrinhjavaweb.convertor.BuildingConvertor;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.enums.BuildingTypeEnum;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

@Service
public class BuildingService implements IBuildingService {

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private BuildingConvertor buildingConvertor;

	@Override
	public List<BuildingDTO> getBuildings(BuildingDTO buildingDTO) {
		BuildingSearchBuilder buildingSearchBuilder = convertToBuilder(buildingDTO);
		List<BuildingEntity> buildingEntities = buildingRepository.getBuildings(buildingSearchBuilder);
		List<BuildingDTO> result = buildingEntities.stream().map(item -> buildingConvertor.convertToBuildingDTO(item))
				.collect(Collectors.toList());
		for (BuildingDTO dto : result) {
			dto.setAddress(dto.getDistrict() + "-" + dto.getWard() + "-" + dto.getStreet());
		}
		for (int i = 0; i < buildingEntities.size(); i++) {
			String rentArea = buildingEntities.get(i).getRentAres().stream().map(item -> item.getValue().toString()).collect(Collectors.joining(","));
			result.get(i).setRentArea(rentArea);
		}
		return result;
	}

	private BuildingSearchBuilder convertToBuilder(BuildingDTO buildingDTO) {
		BuildingSearchBuilder builder = modelMapper.map(buildingDTO, BuilderBuilding.class).build();
		return builder;
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
			String rentArea = listBuildingEntitie.get(i).getRentAres().stream().map(item -> item.getValue().toString()).collect(Collectors.joining(","));
			result.get(i).setRentArea(rentArea);
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

	@Override
	public BuildingDTO saveBuilding(BuildingDTO buildingDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
