package com.cg.mHealthSystem.services;

import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Department;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.entity.PatientDetails;
import com.cg.mHealthSystem.entity.PatientRecords;

public interface PatientService {
	Iterable<Doctor> getAllDoctors();
	Department filterByDepartment(Department department);
	Iterable<Nurse> getAllNurse();
	PatientDetails bookbyId(PatientDetails patientId);
	Appointments viewById(Integer appointmentId);
	PatientDetails updateProfile(Integer patientId, String gender);
	PatientRecords getPatientById(Integer patientId);
	PatientDetails getPatientRecordById(Integer recordId);
	
	
	
	
}
