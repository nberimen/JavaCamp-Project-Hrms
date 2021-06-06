package com.nberimen.city;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nberimen.utilities.result.ErrorDataResult;

@RestController
@RequestMapping("/api/cities")
public class CityController {

	private CityService cityService;

	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.cityService.gettAll());
	}
	@PostMapping("/add")
	public ResponseEntity<?>  add(@Valid @RequestBody City city) {
		return ResponseEntity.ok(this.cityService.register(city));
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
