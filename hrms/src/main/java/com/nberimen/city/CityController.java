package com.nberimen.city;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nberimen.core.utilities.Result;

@RestController
@RequestMapping("/api/cities")
public class CityController {

	private CityService cityService;

	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	public Result getAll() {
		return this.cityService.gettAll();
	}
}
