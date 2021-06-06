package com.nberimen.user.dto;

import com.nberimen.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private int id;
	
	private String email;

	private boolean verified;
	
	public UserDto(User user) { 
		setId(user.getId());
		setEmail(user.getEmail());
		setVerified(user.isEmailVerified());
	}

}
