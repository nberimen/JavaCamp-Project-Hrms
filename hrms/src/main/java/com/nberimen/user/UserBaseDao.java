package com.nberimen.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserBaseDao<T extends User> extends JpaRepository<T, Integer> {
	
	T findByEmail(String email);
	T getById(int id);
}
