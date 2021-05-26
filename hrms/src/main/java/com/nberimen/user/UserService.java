package com.nberimen.user;

public interface UserService {

	public void save(User user);
	public User getUserByEmail(String email);
	
}
