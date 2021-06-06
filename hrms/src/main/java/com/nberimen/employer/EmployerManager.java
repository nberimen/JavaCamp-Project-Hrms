package com.nberimen.employer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.ErrorResult;
import com.nberimen.utilities.result.Result;
import com.nberimen.utilities.result.SuccessDataResult;
import com.nberimen.utilities.result.SuccessResult;


@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao=employerDao;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return  new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İşverenler Listelendi.");
	}

	@Override
	public Result register(Employer employer) {
		String email=employer.getEmail();
		String domain=employer.getEmail().split("@")[1];
		String host = employer.getWebSite()
	            .replaceAll("http://|https://|www.","")
	            .replaceAll("/.*","");
		if(employerDao.findByEmail(email)!=null) {
			return new ErrorResult("Kayit Basarisiz: Bu e-posta kullaniliyor. ");
		}
		
		if(!domain.equalsIgnoreCase(host)) {
			return new ErrorResult("Kayit Basarisiz: E-posta şirket ile uyuşmuyor. ");
		}else {
			employerDao.save(employer);
			
		}
		return new SuccessResult("Kayıt Başarılı: İşveren Eklendi");
	}
	
	
	
}
