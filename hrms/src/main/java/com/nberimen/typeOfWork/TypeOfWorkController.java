package com.nberimen.typeOfWork;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nberimen.utilities.result.ErrorDataResult;

@RestController
@CrossOrigin
@RequestMapping("/api/typesOfWork")
public class TypeOfWorkController {
	
	@Autowired
	private TypeOfWorkService typeOfWorkService;
	
	
	@GetMapping("/gellAll")
	public ResponseEntity<?> gettAll(){
		return ResponseEntity.ok(this.typeOfWorkService.gettAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addTypeOfWork(@Valid @RequestBody TypeOfWork type){
		
		return ResponseEntity.ok(this.typeOfWorkService.addTypeOfWork(type));
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
