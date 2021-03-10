package com.cg.mHealthSystem.services.implementation;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.cg.mHealthSystem.Repository.PatientDetailsRepository;
import com.cg.mHealthSystem.Repository.PatientRecordsRepository;
import com.cg.mHealthSystem.Repository.DepartmentRepository;
import com.cg.mHealthSystem.Repository.DoctorRepository;
import com.cg.mHealthSystem.Repository.NurseRepository;
import com.cg.mHealthSystem.Controllers.PatientController;
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
	private static final Logger logger=LoggerFactory.getLogger(PatientController.class);

	@Override
	public Iterable<Doctor> getAllDoctors() {
		logger.info("In Patient Service, get all doctors method");
		// TODO Auto-generated method stub
		return tDao.findAll();
	}

	
//Filter by Department
	@Autowired
	private DepartmentRepository dDao;
	
	@Override
	public Iterable<Doctor> filterByDepartment(Integer departmentId, String deptName) {
		
		// TODO Auto-generated method stub
		return null;
	}

//Get all Nurses	
	@Autowired
	private NurseRepository nDao;
	
	@Override
	public Iterable<Nurse> getAllNurse() {
		logger.info("In PatientService, get all Nurses method");	
		return nDao.findAll();
	}
	
//Book Appointments	by ID
	@Autowired
	private AppointmentsRepository aDao;
	
	@Override
	public Appointments bookbyId(Appointments appointment) {
		logger.info("In PatientService, Book by id method");
		return aDao.save(appointment);
	}

	
//View Appointments
	@Override
	public Appointments viewById(Integer appointmentId) {
		logger.info("In PatientService, View by id method");
		return aDao.findById(appointmentId).get();
	}

//Update Profile	
	@Override
	public PatientDetails updateProfile(Integer patientId, String dateOfBirth) {
		 PatientDetails patientDetails1 = pDao.findById(patientId).get();
	     patientDetails1.setDateOfBirth(dateOfBirth);
	     logger.info("In PatientService, update Profile method");
	     return pDao.save(patientDetails1);
	}

//Get Patient Record Id
	@Autowired
	private PatientRecordsRepository rDao;
	@Override
	public PatientRecords retreivePatientRecordById(Integer patientId) {
		logger.info("In PatientService, retreive Patient Record ById method");
		return rDao.findById(patientId).get();
	}

	

	

	
	
	
	
	
	

}
