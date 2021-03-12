package com.cg.mHealthSystem.Repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.mHealthSystem.entity.Doctor;
/**
 * 
 * @author ayushranjan
 *
 *Doctor Repository interface which extends CrudRepository 
 */


public interface DoctorRepository  extends CrudRepository< Doctor,Integer > {


}
