package com.cg.mHealthSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cg.mHealthSystem.entity.Department;

/**
 * 
 * @author ayushranjan
 *
 *Department Repository interface which extends CrudRepository 
 */



public interface DepartmentRepository extends CrudRepository<Department,Integer>{

}
