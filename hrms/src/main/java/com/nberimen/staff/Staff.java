package com.nberimen.staff;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.nberimen.user.User;

import lombok.Data;

@Entity
@Table(name = "staff")
@Data
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	private int id;
	
	@OneToOne(optional = false)
	private User user;
	
}
