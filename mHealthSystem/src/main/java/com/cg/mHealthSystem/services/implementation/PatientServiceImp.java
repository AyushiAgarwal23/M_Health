package com.cg.mHealthSystem.services.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.cg.mHealthSystem.Repository.PatientDetailsRepository;
import com.cg.mHealthSystem.Repository.PatientRecordsRepository;
import com.cg.mHealthSystem.Repository.DepartmentRepository;
import com.cg.mHealthSystem.Repository.DoctorRepository;
import com.cg.mHealthSystem.Repository.NurseRepository;
import com.cg.mHealthSystem.Repository.AppointmentsRepository;
import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Department;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.entity.PatientDetails;
import com.cg.mHealthSystem.entity.PatientRecords;
import com.cg.mHealthSystem.services.PatientService;
@Service
@Transactional
public class PatientServiceImp implements PatientService{

	
//Get all Doctors
	@Autowired
	private  PatientDetailsRepository  pDao;

	@Autowired
	private  DoctorRepository  tDao;

	@Override
	public Iterable<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return tDao.findAll();
	}

	
//Filter by Department
	@Autowired
	private DepartmentRepository dDao;
	
	@Override
	public Department filterByDepartment(Department department) {
		
		// TODO Auto-generated method stub
		return null;
	}

//Get all Nurses	
	@Autowired
	private NurseRepository nDao;
	
	@Override
	public Iterable<Nurse> getAllNurse() {
	
		return nDao.findAll();
	}
	
//Book Appointments	
	@Autowired
	private AppointmentsRepository aDao;
	
	@Override
	public PatientDetails bookbyId(PatientDetails patientId) {
		
		
		// TODO Auto-generated method stub
		return pDao.save(patientId);
	}

	
//View Appointments
	@Override
	public Appointments viewById(Integer appointmentId) {
		
		
		// TODO Auto-generated method stub
		return aDao.findById(appointmentId).get();
	}

//Update Profile	
	@Override
	public PatientDetails updateProfile(Integer patientId, String gender) {
		 PatientDetails patientDetails1 = pDao.findById(patientId).get();
	        patientDetails1.setGender(gender);
	        return pDao.save(patientDetails1);
	}

//Get Patient Id and Record Id
	@Autowired
	private PatientRecordsRepository rDao;
	@Override
	public PatientRecords getPatientById(Integer patientId) {
		// TODO Auto-generated method stub
		return rDao.findById(patientId).get();
	}

	@Override
	public PatientDetails getPatientRecordById(Integer recordId) {
		return pDao.findById(recordId).get();
	}

	

	
	
	
	
	
	

}
