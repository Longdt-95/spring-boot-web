package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.enums.DistrictEnum;
import com.laptrinhjavaweb.service.IDistrictService;

@Service
public class DistrictService implements IDistrictService{

	public Map<String,String> getDistricts() {
		Map<String,String> result = new HashMap<>();
		for (DistrictEnum district : DistrictEnum.values()) {
			result.put(district.name(), district.getValue());
		}
		return result;
	}

}
