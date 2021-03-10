package com.cg.mHealthSystem.services;

import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Department;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.entity.PatientDetails;
import com.cg.mHealthSystem.entity.PatientRecords;

public interface PatientService {
	Iterable<Doctor> getAllDoctors();
	Iterable<Doctor> filterByDepartment(Integer departmentId, String deptName);
	Iterable<Nurse> getAllNurse();
	Appointments bookbyId(Appointments appointment);
	Appointments viewById(Integer appointmentId);
	PatientDetails updateProfile(Integer patientId, String dateOfBirth);
	PatientRecords retreivePatientRecordById(Integer patientId);
	
	
	
	
	
}
