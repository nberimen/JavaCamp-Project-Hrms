package com.nberimen.city;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class City {

	@Id
	private int id;
	
	private String cityName;
}
