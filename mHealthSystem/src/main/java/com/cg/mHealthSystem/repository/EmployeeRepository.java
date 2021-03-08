package com.cg.mHealthSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mHealthSystem.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
