package com.nberimen.city;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="cities")
public class City {

	@Id
	private int id;
	
	private String cityName;
}
