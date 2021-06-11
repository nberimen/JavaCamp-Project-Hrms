package com.nberimen.candidate;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nberimen.resume.Resume;
import com.nberimen.utilities.result.ErrorDataResult;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidateController {

	private CandidateService candidateService;

	
	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService=candidateService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.candidateService.getAll());
	}
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id){
		return ResponseEntity.ok(this.candidateService.getById(id));
	}
	@PostMapping("/register")
	public ResponseEntity<?>  add(@Valid @RequestBody Candidate candidate) {
		return ResponseEntity.ok(this.candidateService.register(candidate));
	}
	
	@PostMapping("/createresume/{id}")
	public ResponseEntity<?> createResume(@RequestBody Resume resume,@PathVariable("id") int candidateId) {
		return ResponseEntity.ok(this.candidateService.saveResume(resume,candidateId));
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
