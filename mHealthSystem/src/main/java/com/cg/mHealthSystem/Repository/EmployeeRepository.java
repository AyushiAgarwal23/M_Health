package com.cg.mHealthSystem.Repository;


import org.springframework.data.repository.CrudRepository;

import com.cg.mHealthSystem.entity.Employee;
/**
 * 
 * @author ayushranjan
 *
 *Employee Repository interface which extends CrudRepository 
 */




public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
