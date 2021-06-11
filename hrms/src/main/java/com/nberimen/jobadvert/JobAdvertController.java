package com.nberimen.jobadvert;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nberimen.jobadvert.dto.JobAdvertDto;
import com.nberimen.utilities.result.ErrorDataResult;

@RestController
@RequestMapping("/api/jobAdverts")
public class JobAdvertController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}

	@PostMapping("/addAdvert")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertDto advertDto) {
		return ResponseEntity.ok( this.jobAdvertService.addAdvert(advertDto));
	}
	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok( this.jobAdvertService.getAll());
	}
	
	@PostMapping("/changeActive/{id}")
	public ResponseEntity<?> changeActive(@PathVariable int id) {
		return ResponseEntity.ok( this.jobAdvertService.changeActive(id));
	}
	
	@GetMapping("/getallByPage")
	public ResponseEntity<?> getAll(@RequestParam int pageNo,@RequestParam int pageSize) {
		return ResponseEntity.ok( this.jobAdvertService.getAll(pageNo, pageSize));
	}
	@GetMapping("/getAllByPublishingDate")
	public ResponseEntity<?> getAllByPublishingDate(@RequestParam int pageNo,@RequestParam int pageSize,
			@RequestParam LocalDate publishingDate) {
		return ResponseEntity.ok( this.jobAdvertService.getAllByPublishingDate(pageNo, pageSize,publishingDate));
	}
	@GetMapping("/getAllByCompanyName")
	public ResponseEntity<?> getByActiveAndEmployer_CompanyName(@RequestParam int pageNo,@RequestParam int pageSize
			,@RequestParam  String companyName) {
		return ResponseEntity.ok(this.jobAdvertService.getAllByCompanyName(pageNo, pageSize,companyName));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors= new HashMap<String, String>();
		for(FieldError fieldError: exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors=new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
		return errors;
	}
}


