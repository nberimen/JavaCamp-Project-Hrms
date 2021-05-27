package com.nberimen.employer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nberimen.core.utilities.DataResult;
import com.nberimen.core.utilities.ErrorResult;
import com.nberimen.core.utilities.Result;
import com.nberimen.core.utilities.SuccessDataResult;
import com.nberimen.core.utilities.SuccessResult;
import com.nberimen.employer.dto.EmployerDto;
import com.nberimen.user.User;
import com.nberimen.user.UserService;


@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserService userService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserService userService) {
		this.employerDao=employerDao;
		this.userService=userService;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return  new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İşverenler Listelendi.");
	}

	@Override
	public Result register(EmployerDto employerDto) {
		String email=employerDto.getEmail();
		String domain=employerDto.getEmail().split("@")[1];
		String host = employerDto.getWebSite()
	            .replaceAll("http://|https://|www.","")
	            .replaceAll("/.*","");
		if(userService.getUserByEmail(email)!=null) {
			return new ErrorResult("Kayit Basarisiz: Bu e-posta kullaniliyor. ");
		}
		
		if(!domain.equalsIgnoreCase(host)) {
			return new ErrorResult("Kayit Basarisiz: E-posta şirket ile uyuşmuyor. ");
		}else {
			Employer employer=employerDtoToEmpoloyer(employerDto);
			employerDao.save(employer);
			
		}
		return new SuccessResult("Kayıt Başarılı: İşveren Eklendi");
	}
	
	

	@Override
	public DataResult<Employer> getEmployer(EmployerDto employerDto) {
		User user=new User();
		user.setEmail(employerDto.getEmail());
		user.setPassword(employerDto.getPassword());
		user.setVerified(false);
		
		Employer employer=new Employer();
		employer.setUser(user);
		employer.setCompanyName(employerDto.getCompanyName());
		employer.setPhoneNumber(employerDto.getPhoneNumber());
		employer.setWebSite(employerDto.getWebSite());
		employer.setVerified(false);
		return new SuccessDataResult<Employer>(employer ,employer.getCompanyName()+"");
	}
	
	public Employer employerDtoToEmpoloyer(EmployerDto employerDto) {
		User user=new User();
		user.setEmail(employerDto.getEmail());
		user.setPassword(employerDto.getPassword());
		user.setVerified(false);
		
		Employer employer =new Employer();
		employer.setUser(user);
		employer.setCompanyName(employerDto.getCompanyName());
		employer.setPhoneNumber(employerDto.getPhoneNumber());
		employer.setVerified(false);
		employer.setWebSite(employerDto.getWebSite());
		return employer;
		
		
	}
}
