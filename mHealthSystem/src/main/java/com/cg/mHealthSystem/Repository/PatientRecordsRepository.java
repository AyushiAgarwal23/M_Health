package com.cg.mHealthSystem.Repository;


import org.springframework.data.repository.CrudRepository;
import com.cg.mHealthSystem.entity.PatientRecords;
/**
 * 
 * @author ayushranjan
 *
 *Repository interface which extends CrudRepository 
 */


public interface PatientRecordsRepository  extends CrudRepository<PatientRecords,Integer> {

}
