package com.cg.mHealthSystem.Repository;


import org.springframework.data.repository.CrudRepository;

import com.cg.mHealthSystem.entity.Nurse;

/**
 * 
 * @author ayushranjan
 *
 * Nurse Repository interface which extends CrudRepository 
 */


public interface NurseRepository extends CrudRepository<Nurse,Integer>{

}
