package com.nberimen.jobadvert;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nberimen.core.utilities.DataResult;
import com.nberimen.core.utilities.Result;
import com.nberimen.jobadvert.dto.JobAdvertDto;

@RestController
@RequestMapping("/api/jobAdverts")
public class JobAdvertController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}

	@PostMapping("/addAdvert")
	public Result add(@Valid @RequestBody JobAdvertDto advertDto) {
		return this.jobAdvertService.addAdvert(advertDto);
	}
	@GetMapping("/getallByPage")
	public DataResult<List<JobAdvert>> getAll(@RequestParam int pageNo,@RequestParam int pageSize) {
		return this.jobAdvertService.getAll(pageNo, pageSize);
	}
	@GetMapping("/getAllByPublishingDate")
	public DataResult<List<JobAdvert>> getAllByPublishingDate(@RequestParam int pageNo,@RequestParam int pageSize,
			@RequestParam LocalDate publishingDate) {
		return this.jobAdvertService.getAllByPublishingDate(pageNo, pageSize,publishingDate);
	}
	@GetMapping("/getAllByCompanyName")
	public DataResult<List<JobAdvert>> getByActiveAndEmployer_CompanyName(@RequestParam int pageNo,@RequestParam int pageSize
			,@RequestParam  String companyName) {
		return this.jobAdvertService.getAllByCompanyName(pageNo, pageSize,companyName);
	}
}


