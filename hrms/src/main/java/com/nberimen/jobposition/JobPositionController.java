package com.nberimen.jobposition;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nberimen.core.utilities.DataResult;
import com.nberimen.core.utilities.Result;
import com.nberimen.jobposition.dto.JobPositionDto;


@RestController
@RequestMapping("/api/positions")
public class JobPositionController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getall")
	public DataResult <List<JobPosition>> getAll(){
		return this.jobPositionService.getAll();
	}
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobPositionDto jobPositionDto) {
		return this.jobPositionService.add(jobPositionDto);
	}
	
}
