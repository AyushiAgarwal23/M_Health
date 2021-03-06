/** 	
    * @author Ayushi
    * 
    * 
    * This is the Class for Patient service
    */

package com.cg.mHealthSystem.services;


import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.entity.PatientDetails;
import com.cg.mHealthSystem.entity.PatientRecords;

public interface PatientService {
	Iterable<Doctor> getAllDoctors();
	Iterable<Nurse> getAllNurse();
	Appointments bookbyId( Integer patientId, Appointments appointment);
	Appointments viewById(Integer pateintId);
	PatientDetails updateProfile(PatientDetails patientDetails);
	PatientRecords retreivePatientRecordById(Integer patientId);
	
	PatientDetails insert(PatientDetails patientDetails);
	
	
	
	
	
}
