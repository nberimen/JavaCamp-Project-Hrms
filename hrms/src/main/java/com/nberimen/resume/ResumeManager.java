package com.nberimen.resume;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nberimen.education.Education;
import com.nberimen.experience.Experience;
import com.nberimen.language.Language;
import com.nberimen.technicalSkill.TechnicalSkill;
import com.nberimen.utilities.cloudinary.CloudinaryService;
import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.ErrorDataResult;
import com.nberimen.utilities.result.Result;
import com.nberimen.utilities.result.SuccessDataResult;
import com.nberimen.utilities.result.SuccessResult;

@Service
public class ResumeManager implements ResumeService{

	@Autowired
	private ResumeDao resumeDao;
	private CloudinaryService cloudinaryService;
	
	
	@Override
	public DataResult<String>  saveProfileImage(MultipartFile multipartFile,int id) {
		Resume resume=getResumeById(id).getData();
		Map<?,?> result;
		String profileImage ;
		
		try {
			result=cloudinaryService.upload(multipartFile) ;
			profileImage= (String) result.get("url");
			resume.setProfileImage(profileImage);
			resumeDao.save(resume);
		} catch (IOException e) {
			e.printStackTrace();
			return new ErrorDataResult<String>(null,e.getMessage());
		}
		return new SuccessDataResult<>(profileImage);
	}

	@Override
	public Result saveSocialAccounts(String githubAccount,String linkedinAccount,int id) {
		Resume resume =getResumeById(id).getData();
		resume.setGithubAccount(githubAccount);
		resume.setLinkedinAccount(linkedinAccount);
		return new SuccessResult("Hesaplar Eklendi.");
		
	}
	@Override
	public DataResult<Resume>  getResumeById(int id) {
		Optional<Resume> resume=resumeDao.findById(id);
		if (!resume.isPresent()) {
			return new ErrorDataResult<Resume>("CV bulunamadı.");
		}
		return new SuccessDataResult<Resume>(resume.get(),"CV");
	}

	@Override
	public Result addSummaryInformation(String summary, int id) {
		Resume resume =getResumeById(id).getData();
		resume.setSummaryInformation(summary);
		return new SuccessResult("Özet Eklendi.");
		
	}

	@Override
	public Result saveLanguage(Language language, int id) {
		Resume resume =getResumeById(id).getData();
		language.setResume(resume);
		resume.getLanguages().add(language);
		resumeDao.save(resume);
		return new SuccessResult("Dil Eklendi.");
		
	}

	@Override
	public Result saveExperience(Experience experience, int id) {
		Resume resume =getResumeById(id).getData();
		experience.setResume(resume);
		resume.getExperiences().add(experience);
		resumeDao.save(resume);
		return new SuccessResult("Deneyim Eklendi.");
		
	}

	@Override
	public Result saveEducation(Education education, int id) {
		Resume resume =getResumeById(id).getData();
		education.setResume(resume);
		resume.getEducation().add(education);
		resumeDao.save(resume);
		return new SuccessResult("Eğitim Eklendi.");
		
	}

	@Override
	public Result saveTechnicalSkill(TechnicalSkill technicalSkill, int id) {
		Resume resume =getResumeById(id).getData();
		technicalSkill.setResume(resume);
		resume.getTechnicalSkills().add(technicalSkill);
		resumeDao.save(resume);
		return new SuccessResult("Teknik Bilgi Eklendi.");
	}
	
}
