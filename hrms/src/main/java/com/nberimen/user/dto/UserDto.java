package com.nberimen.user.dto;

import com.nberimen.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
	
	private int id;
	
	private String email;

	private boolean enabled;
	
	public UserDto(User user) { 
		setId(user.getId());
		setEmail(user.getEmail());
		setEnabled(user.isVerified());
	}

}
