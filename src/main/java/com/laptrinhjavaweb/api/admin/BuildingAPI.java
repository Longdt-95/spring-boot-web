package com.laptrinhjavaweb.api.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IBuildingService;

@RestController (value = "buildingApiOfAdmin")
public class BuildingAPI {
	
	@Autowired
	private IBuildingService buildingService;
	
	@GetMapping("/buildings")
	public List<BuildingDTO> getBuildingsSearch(@RequestParam(required = false) Map<String, String> requestParams,
			@RequestParam(required = false) String[] type) {
		return buildingService.getBuildings(requestParams, type);
	}
	
	@PostMapping("/buildings")
	public BuildingDTO saveBuilding(@RequestBody BuildingDTO buildingDTO) {
		return buildingService.saveBuilding(buildingDTO);
	}
}
