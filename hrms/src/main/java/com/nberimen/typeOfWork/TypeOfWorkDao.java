package com.nberimen.typeOfWork;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfWorkDao extends JpaRepository<TypeOfWork, Integer>{

}
