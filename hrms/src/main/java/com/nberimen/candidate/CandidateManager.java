package com.nberimen.candidate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nberimen.core.utilities.DataResult;
import com.nberimen.core.utilities.ErrorResult;
import com.nberimen.core.utilities.Result;
import com.nberimen.core.utilities.SuccessDataResult;
import com.nberimen.core.utilities.SuccessResult;
import com.nberimen.user.UserService;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserService userService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao,  UserService userService) {
		super();
		this.candidateDao = candidateDao;
		this.userService = userService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Adaylar Listelendi");
	}

	@Override
	public Result register(Candidate candidate) {
		String email=candidate.getUser().getEmail();
		if(userService.getUserByEmail(email)!=null) {
			return new ErrorResult("Kayit Basarisiz: Bu e-posta kullaniliyor. ");
		}else if(candidateDao.findByNationalityId(candidate.getNationalityId())!=null) {
			return new ErrorResult("Kayit Basarisiz: Bu TC zaten kayitli.");
		}
		candidateDao.save(candidate);
		return new SuccessResult("Kayıt başarılıı");
		
	}

}
