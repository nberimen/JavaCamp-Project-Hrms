package com.nberimen.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "email",nullable = false,unique = true)
	private String email;
	
	@Column(name="password",nullable = false)
	private String password;
	
	@Column(name="verified",nullable = false)
	private boolean verified;
	
}
