package com.nberimen.candidate;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nberimen.candidate.dto.CandidateDto;
import com.nberimen.core.utilities.DataResult;
import com.nberimen.core.utilities.Result;
import com.nberimen.user.User;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

	private CandidateService candidateService;

	
	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService=candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	@PostMapping("/register")
	public Result add(@Valid @RequestBody CandidateDto candidateDto) {
		Candidate candidate =new Candidate();
		candidate.setFirstName(candidateDto.getFirstName());
		candidate.setLastName(candidateDto.getLastName());
		candidate.setDateOfBirth(candidateDto.getDateOfBirth());
		candidate.setNationalityId(candidateDto.getNationalityId());
		User user = new User(candidateDto.getEmail(),candidateDto.getPassword(),false);
		candidate.setUser(user);
		return candidateService.register(candidate);
		//return new SuccessDataResult<Candidate>(candidate,"başarılı");
	}
}
