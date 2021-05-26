package com.nberimen.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	public User getUserByEmail(String email) {
		
		return userDao.findByEmail(email);
	}
}
