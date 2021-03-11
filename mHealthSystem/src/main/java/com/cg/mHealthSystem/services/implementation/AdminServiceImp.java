package com.cg.mHealthSystem.services.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mHealthSystem.Controllers.PatientController;
import com.cg.mHealthSystem.Repository.DepartmentRepository;
import com.cg.mHealthSystem.Repository.DoctorRepository;
import com.cg.mHealthSystem.Repository.NurseRepository;
import com.cg.mHealthSystem.Repository.PatientDetailsRepository;
import com.cg.mHealthSystem.entity.Department;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.entity.PatientDetails;
import com.cg.mHealthSystem.services.AdminService;
@Service
@Transactional
public class AdminServiceImp implements AdminService {
	@Autowired
	private  DoctorRepository  doctorDao;
	@Autowired
	private NurseRepository nurseDao;
	
	@Autowired
	private DepartmentRepository departmentDao ;

	private PatientDetailsRepository patientDao;
	
	private static final Logger logger=LoggerFactory.getLogger(PatientController.class);

	@Override
	public Doctor addDoctor(Doctor doctor) {
		logger.info("In Admin Service, add doctor method");
		return doctorDao.save(doctor);
	}

	@Override
	public Nurse addNurse(Nurse nurse) {
		logger.info("In Admin Service, add nurse method");
		return nurseDao.save(nurse);
	}

	@Override
	public boolean removeDoctorById(Integer doctorId) {

		doctorDao.deleteById(doctorId);
	
		Optional<Doctor> doctor = doctorDao.findById(doctorId);
		logger.info("In Admin Service,remove doctor method");
		return !(doctor.isPresent());
	}

	@Override
	public boolean removeNurseById(Integer nurseId) {
		nurseDao.deleteById(nurseId);
		Optional<Nurse> nurse = nurseDao.findById(nurseId);
		logger.info("In Admin Service, Remove nurse method");
		return !(nurse.isPresent());
	}

	@Override
	public Department addDepartment(Department department) {
		logger.info("In Admin Service, add department method");
		return departmentDao.save(department);
	}

	@Override
	public boolean removeDepartment(Integer deptId) {

		departmentDao.deleteById(deptId);
		Optional<Department> department = departmentDao.findById(deptId);
		logger.info("In Admin Service, delete by id method");
		return !(department.isPresent());
	}

	@Override
	public boolean removePatient(Integer patientId) {

		patientDao.deleteById(patientId);
		Optional<PatientDetails> patientDetails = patientDao.findById(patientId);
		logger.info("In Admin Service, Remove patient method");
		return !(patientDetails.isPresent());
	}

	@Override
	public Department findDepartmentById(Integer deptId) {
		
		return departmentDao.findById(deptId).get();
		
	}

}
