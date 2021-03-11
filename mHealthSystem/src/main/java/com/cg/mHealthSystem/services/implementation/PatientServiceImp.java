package com.cg.mHealthSystem.services.implementation;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	

/*Get all Nurses*/	
	@Autowired
	private NurseRepository nDao;
	
	@Override
	public Iterable<Nurse> getAllNurse() {
		logger.info("In PatientService, get all Nurses method");	
		return nDao.findAll();
	}
	
/*Book Appointments	by ID*/
	@Autowired
	private AppointmentsRepository aDao;
	
	@Override
	public Appointments bookbyId(Integer patientId, Appointments appointment) {
		logger.info("In PatientService, Book by id method");
		PatientDetails patient= pDao.findById(patientId).get();
		patient.setAppointment(appointment);
		
		PatientDetails patient1= pDao.save(patient);
		return patient1.getAppointment();
		 
	}

	
/*View Appointments*/
	@Override
	public Appointments viewById(Integer patientId) {
		logger.info("In PatientService, View by id method");
		return pDao.findById(patientId).get().getAppointment();
	}

/*Update Profile*/	
	@Override
	public PatientDetails updateProfile(PatientDetails patientDetails) {
		 PatientDetails patientDetails1=new  PatientDetails();
		 if(!pDao.findById(patientDetails.getPatientId()).isPresent()){
			  patientDetails1 = pDao.findById(patientDetails.getPatientId()).get();
		}
		 
		 if(patientDetails.getCity()==null) {
			 patientDetails.setCity(patientDetails1.getCity());
		 }
			 else {
					patientDetails1.setCity(patientDetails.getCity());
				}
		 
		 if (patientDetails.getFirstName() == null) {
			 patientDetails.setFirstName(patientDetails1.getFirstName());
			}

			// if everything is fine, we will update the username to original one
			else {
				patientDetails1.setFirstName(patientDetails.getFirstName());
			}

			// checking if user enters password as null, the original value should remain
			// intact
			if (patientDetails.getDateOfBirth() == null) {
				patientDetails.setDateOfBirth(patientDetails1.getDateOfBirth());
			}

			else {
				patientDetails1.setDateOfBirth(patientDetails.getDateOfBirth());
			}

			if (patientDetails.getGender() == null) {
				patientDetails.setGender(patientDetails.getGender());
			}


			else {
				patientDetails1.setGender(patientDetails.getGender());
			}
			if (patientDetails.getLastName() == null) {
				patientDetails.setLastName(patientDetails1.getLastName());
			}

			else {
				patientDetails1.setLastName(patientDetails.getLastName());
			}
		 
	   
	     logger.info("In PatientService, update Profile method");
	     return pDao.save(patientDetails1);
	}

/*Get Patient Record Id*/
	@Autowired
	private PatientRecordsRepository rDao;
	@Override
	public PatientRecords retreivePatientRecordById(Integer patientId) {
		logger.info("In PatientService, retreive Patient Record ById method");
		return pDao.findById(patientId).get().getPatientrecords();
	}

	/*Insert into Patient Details*/
@Override
public PatientDetails insert(PatientDetails patientDetails) {
	logger.info("In PatientService, Insert method");
	return pDao.save(patientDetails);
	
}
	

	

	
	
	
	
	
	

}
