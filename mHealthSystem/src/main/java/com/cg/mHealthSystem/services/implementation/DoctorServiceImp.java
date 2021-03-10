package com.cg.mHealthSystem.services.implementation;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mHealthSystem.Controllers.PatientController;
import com.cg.mHealthSystem.Repository.AppointmentsRepository;
import com.cg.mHealthSystem.Repository.DoctorRepository;
import com.cg.mHealthSystem.Repository.PatientRecordsRepository;
import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.PatientDetails;
import com.cg.mHealthSystem.entity.PatientRecords;
import com.cg.mHealthSystem.services.DoctorService;

@Service
@Transactional
public class DoctorServiceImp implements DoctorService {
	@Autowired
	private  DoctorRepository  doctorDao;
	
	private static final Logger logger=LoggerFactory.getLogger(PatientController.class);

	@Override
	public Doctor addDoctor(Doctor doctor) {
		logger.info("In Doctor Service, add doctor method");
		return doctorDao.save(doctor);
	}

	@Override
	public Doctor updateProfile(Integer doctorId, Integer deptId) {
		Doctor doctor = doctorDao.findById(doctorId).get();
        //doctor.setDepartment(deptId);
		logger.info("In Doctor Service,updateProfile method");
        return doctorDao.save(doctor);
	}
	
	@Autowired
	private AppointmentsRepository aDao;

	@Override
	public Appointments viewAppointment(Integer appointmentId) 
	{
		logger.info("In Doctor Service, viewAppointment method");
		return aDao.findById(appointmentId).get();
		
	}
	
	@Autowired
	private PatientRecordsRepository prDao;

	@Override
	public PatientRecords patientRecord(Integer patientId) 
	{
		logger.info("In Doctor Service, patientRecord method");
		return prDao.findById(patientId).get();
		
		
	}

}
