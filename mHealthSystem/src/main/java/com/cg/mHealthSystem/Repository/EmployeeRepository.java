package com.cg.mHealthSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mHealthSystem.entity.Employee;





public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}