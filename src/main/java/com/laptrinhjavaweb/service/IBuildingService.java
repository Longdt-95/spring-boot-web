package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.dto.BuildingDTO;

public interface IBuildingService {

	Map<String,String> getBuildingTypes();
	List<BuildingDTO> getBuildings(BuildingDTO buildingDTO);
	List<BuildingDTO> getBuildings(Map<String, String> requestParams, String[] type);
	BuildingDTO saveBuilding(BuildingDTO buildingDTO);
	BuildingDTO findById(long id);
	void delBuilding(long[] buildingIds);
	void assignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO);
}
