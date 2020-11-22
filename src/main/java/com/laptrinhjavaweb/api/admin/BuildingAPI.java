package com.laptrinhjavaweb.api.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.IUserService;

@RestController (value = "buildingApiOfAdmin")
public class BuildingAPI {
	
	@Autowired
	private IBuildingService buildingService;
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/api/buildings")
	public List<BuildingDTO> getBuildingsSearch(@RequestParam(required = false) Map<String, String> requestParams,
			@RequestParam(required = false) String[] type) {
		return buildingService.getBuildings(requestParams, type);
	}
	
	@PostMapping("/api/buildings")
	public BuildingDTO saveBuilding(@RequestBody BuildingDTO buildingDTO) {
		return buildingService.saveBuilding(buildingDTO);
	}
	
	@DeleteMapping("/api/building")
	public void delBuilding(@RequestBody long[] buildingIds) {
		buildingService.delBuilding(buildingIds);
	}
	
	@GetMapping("/api/assign-building")
	public List<UserDTO> getStaffs(@RequestParam long buildingId, @RequestParam String role) {
		List<UserDTO> listResult = userService.findAllStaffAssignBuilding(buildingId, role);
		return listResult;
	}
	
	@PostMapping("/api/assignment-building")
	public void addManagerBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {
		 buildingService.assignmentBuilding(assignmentBuildingDTO);
	}
}
