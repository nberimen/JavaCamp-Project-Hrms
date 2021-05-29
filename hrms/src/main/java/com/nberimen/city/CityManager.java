package com.nberimen.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nberimen.core.utilities.DataResult;
import com.nberimen.core.utilities.SuccessDataResult;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> gettAll() {
		
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Şehirler Listelendi.");
	}

}
