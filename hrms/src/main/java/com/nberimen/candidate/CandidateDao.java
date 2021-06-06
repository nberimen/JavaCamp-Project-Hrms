package com.nberimen.candidate;

import org.springframework.stereotype.Repository;

import com.nberimen.user.UserBaseDao;

@Repository
public interface CandidateDao extends UserBaseDao<Candidate> {

	Candidate findByNationalityId(String nationalityId);
	
	
}