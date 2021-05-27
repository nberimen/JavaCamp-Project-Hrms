package com.nberimen.jobposition;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	public boolean findByPositionName(String positionName);

}
