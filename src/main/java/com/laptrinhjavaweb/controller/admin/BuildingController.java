package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.IDistrictService;
import com.laptrinhjavaweb.service.IUserService;

@Controller
public class BuildingController {

	@Autowired
	private IDistrictService districtService;

	@Autowired
	private IBuildingService buildingService;

	@Autowired
	private IUserService userService;


	@RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
	public ModelAndView buildingList(@ModelAttribute("modelSearch") BuildingDTO buildingDTO) {
		ModelAndView mav = new ModelAndView("admin/building/list");
		mav.addObject("modelSearch", buildingDTO);
		mav.addObject("districts", districtService.getDistricts());
		mav.addObject("buildingTypes", buildingService.getBuildingTypes());
		mav.addObject("staffMap", userService.getStaffMaps());
		mav.addObject("buildings", buildingService.getBuildings(buildingDTO));
		return mav;
	}

	@RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
	public ModelAndView buildingEdit(@ModelAttribute("newModel") BuildingDTO buildingDTO) {
		ModelAndView mav = new ModelAndView("admin/building/edit");
		mav.addObject("buildingTypes", buildingService.getBuildingTypes());
		mav.addObject("districts", districtService.getDistricts());
		if (buildingDTO.getId() != null) {
			mav.addObject("newModel", buildingService.findById(buildingDTO.getId()));
		} else {
		mav.addObject("newModel", new BuildingDTO());
		}
		return mav;
	}
}
