package com.cg.mHealthSystem.Repository;


import org.springframework.data.repository.CrudRepository;

import com.cg.mHealthSystem.entity.PatientDetails;

/**
 * 
 * @author ayushranjan
 *
 * PatientDetials Repository interface which extends CrudRepository 
 */
public interface PatientDetailsRepository  extends CrudRepository <PatientDetails,Integer>{

}
