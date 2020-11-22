package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.service.impl.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/admin/customer-list", method = RequestMethod.GET)
	public ModelAndView buildingList(@ModelAttribute("modelSearch") CustomerDTO customerDTO) {
		ModelAndView mav = new ModelAndView("admin/customer/list");
		mav.addObject("modelSearch", customerDTO);
		mav.addObject("staffMap", userService.getStaffMaps());
		mav.addObject("customers", customerService.getListCustomerSearch(customerDTO));
		return mav;
	}
	
	@RequestMapping(value = "/admin/customer-edit", method = RequestMethod.GET)
	public ModelAndView buildingEdit(@ModelAttribute("newModel") CustomerDTO customerDTO) {
		ModelAndView mav = new ModelAndView("admin/customer/edit");
		if (customerDTO.getId() != null) {
			mav.addObject("newModel", customerService.findById(customerDTO.getId()));
		} else {
		mav.addObject("newModel", new CustomerDTO());
		}
		return mav;
	}
}
