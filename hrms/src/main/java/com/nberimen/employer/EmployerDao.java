package com.nberimen.employer;

import org.springframework.stereotype.Repository;

import com.nberimen.user.UserBaseDao;

@Repository
public interface EmployerDao extends UserBaseDao<Employer> {

}
