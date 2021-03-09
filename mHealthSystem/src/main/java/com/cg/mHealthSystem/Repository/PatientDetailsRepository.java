package com.cg.mHealthSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cg.mHealthSystem.entity.PatientDetails;

public interface PatientDetailsRepository  extends CrudRepository <PatientDetails,Integer>{

}
