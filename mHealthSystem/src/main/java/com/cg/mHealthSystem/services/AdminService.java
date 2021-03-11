package com.cg.mHealthSystem.services;



import com.cg.mHealthSystem.entity.Department;

import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Nurse;


public interface AdminService {
	
	
	Doctor addDoctor(Doctor doctor);
	Nurse addNurse(Nurse nurse );
	boolean removeDoctorById(Integer doctorId);
	boolean removeNurseById(Integer nurseId);
	Department addDepartment(Department department);
	boolean removeDepartment(Integer deptId);
	boolean removePatient(Integer patientId);
	Department findDepartmentById(Integer deptId);
	

}
