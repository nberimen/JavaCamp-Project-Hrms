package com.nberimen.resume;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nberimen.education.Education;
import com.nberimen.experience.Experience;
import com.nberimen.language.Language;
import com.nberimen.technicalSkill.TechnicalSkill;


@RestController
@RequestMapping("/api/resume")
@CrossOrigin
public class ResumeController {

	@Autowired
	private ResumeService resumeService;
	
	
	@GetMapping("/getResume")
	public ResponseEntity<?> getResume(@RequestParam int id){
		return ResponseEntity.ok(this.resumeService.getResumeById(id));
	}
	
	
	@PostMapping("/image-upload")
	public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile, @RequestParam int id){
		return ResponseEntity.ok(this.resumeService.saveProfileImage(multipartFile, id));
	}
	
	@PostMapping("/social-accounts")
	public ResponseEntity<?> saveSocialAccounts(@RequestParam String githubAccount,
			@RequestParam String linkedinAccount, @RequestParam int id){
		return ResponseEntity.ok(this.resumeService.saveSocialAccounts(githubAccount, linkedinAccount, id));
	}
	
	@PostMapping("/summary")
	public ResponseEntity<?> addSummaryInformation(@RequestParam String summary,@RequestParam int id){
		return ResponseEntity.ok(this.resumeService.addSummaryInformation(summary, id));
	}
	
	@PostMapping("/language-skills")
	public ResponseEntity<?> saveLanguageSkill(@RequestParam Language language,@RequestParam int id){
		return ResponseEntity.ok(this.resumeService.saveLanguage(language, id));
	}
	
	@PostMapping("/experiences")
	public ResponseEntity<?> saveExperience(@RequestParam Experience experience,@RequestParam int id){
		return ResponseEntity.ok(this.resumeService.saveExperience(experience, id));
	}
	
	@PostMapping("/education")
	public ResponseEntity<?> saveEducation(@RequestParam Education education,@RequestParam int id){
		return ResponseEntity.ok(this.resumeService.saveEducation(education, id));
	}
	
	@PostMapping("/technical-skills")
	public ResponseEntity<?> saveTechnicalSkill(@RequestParam TechnicalSkill technicalSkill,@RequestParam int id){
		return ResponseEntity.ok(this.resumeService.saveTechnicalSkill(technicalSkill, id));
	}
	
	
	
}
