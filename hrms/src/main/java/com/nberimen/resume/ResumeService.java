package com.nberimen.resume;

import org.springframework.web.multipart.MultipartFile;

import com.nberimen.education.Education;
import com.nberimen.experience.Experience;
import com.nberimen.language.Language;
import com.nberimen.technicalSkill.TechnicalSkill;
import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.Result;

public interface ResumeService {

	public DataResult<String> saveProfileImage(MultipartFile multipartFile, int id);
	
	public Result saveSocialAccounts(String githubAccount,String linkedinAccount,int id);
	
	public DataResult<Resume> getResumeById(int id);
	
	public Result addSummaryInformation(String summary, int id);
	
	public Result saveLanguage(Language language, int id);
	
	public Result saveExperience(Experience experience, int id);
	
	public Result saveEducation(Education education, int id);
	
	public Result saveTechnicalSkill(TechnicalSkill technicalSkill, int id);
	
	
}
