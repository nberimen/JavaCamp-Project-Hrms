package com.nberimen.candidate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nberimen.resume.Resume;
import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.ErrorDataResult;
import com.nberimen.utilities.result.ErrorResult;
import com.nberimen.utilities.result.Result;
import com.nberimen.utilities.result.SuccessDataResult;
import com.nberimen.utilities.result.SuccessResult;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Adaylar Listelendi");
	}

	@Override
	public Result register(Candidate candidate) {
		String email=candidate.getEmail();
		if(candidateDao.findByEmail(email)!=null) {
			return new ErrorResult("Kayit Basarisiz: Bu e-posta kullaniliyor. ");
		}else if(candidateDao.findByNationalityId(candidate.getNationalityId())!=null) {
			return new ErrorResult("Kayit Basarisiz: Bu TC zaten kayitli.");
		}
		candidateDao.save(candidate);
		return new SuccessResult("Kayıt başarılı");
		
	}
	@Override
	public Result saveResume(Resume resume, int candidateId) {
		Candidate candidate = candidateDao.findById(candidateId).get();
		candidate.setResume(resume);
		candidateDao.save(candidate);
		return new SuccessResult("Kayıt başarılı");
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		Candidate candidate=this.candidateDao.getById(id);
		if(candidate==null)
			return new ErrorDataResult<>("Böyle bir aday yok.");
		return new SuccessDataResult<>(candidate);
	}

}
