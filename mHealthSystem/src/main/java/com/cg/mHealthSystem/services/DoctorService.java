package com.cg.mHealthSystem.services;

import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Department;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.PatientRecords;


public interface DoctorService {
	
	
	Doctor updateProfile(Integer doctorId, Department department);
	Appointments viewAppointment(Integer appointmentId);
	PatientRecords patientRecord(Integer patientId);
	Doctor addDoctor(Doctor doctor);

}
