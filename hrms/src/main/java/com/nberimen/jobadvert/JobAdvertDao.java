package com.nberimen.jobadvert;



import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	Page<JobAdvert> getByActive(boolean active,Pageable pageable);
	Page<JobAdvert> getByActiveAndPublishingDate(boolean active,LocalDate publishingDate,Pageable pageable);
	Page<JobAdvert> getByActiveAndEmployer_CompanyName(boolean active,String companyName,Pageable pageable);
}
