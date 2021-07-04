package com.nberimen.jobType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeDao extends JpaRepository<JobType, Integer> {

}
