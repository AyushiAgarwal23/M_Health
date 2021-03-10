package com.cg.mHealthSystem.services.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Override
	public Doctor addDoctor(Doctor doctor) {
		
		
		return doctorDao.save(doctor);
	}

	@Override
	public Doctor updateProfile(Integer doctorId, Integer deptId) {
		Doctor doctor = doctorDao.findById(doctorId).get();
        //doctor.setDepartment(deptId);
        return doctorDao.save(doctor);
	}
	
	@Autowired
	private AppointmentsRepository aDao;

	@Override
	public Appointments viewAppointment(Integer appointmentId) 
	{
		return aDao.findById(appointmentId).get();
	}
	
	@Autowired
	private PatientRecordsRepository prDao;

	@Override
	public PatientRecords patientRecord(Integer patientId) 
	{
		return prDao.findById(patientId).get();
		
		
	}

}
