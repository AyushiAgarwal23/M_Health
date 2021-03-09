package com.cg.mHealthSystem.services.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	@Override
	public Doctor addDoctor(Doctor doctor) {
		
		
		return doctorDao.save(doctor);
	}

	@Override
	public Nurse addNurse(Nurse nurse) {
		
		return nurseDao.save(nurse);
	}

	@Override
	public boolean removeDoctorById(Integer doctorId) {

		doctorDao.deleteById(doctorId);
	
		Optional<Doctor> doctor = doctorDao.findById(doctorId);
		
		
		/*if(doctor.equals(null) )
		{
			return true ;
		}*/
		return !(doctor.isPresent());
	}

	@Override
	public boolean removeNurseById(Integer nurseId) {
		nurseDao.deleteById(nurseId);
		Optional<Nurse> nurse = nurseDao.findById(nurseId);
		
		
		return !(nurse.isPresent());
	}

	@Override
	public Department addDepartment(Department department) {

		
		return departmentDao.save(department);
	}

	@Override
	public boolean removeDepartment(Integer deptId) {

		departmentDao.deleteById(deptId);
		Optional<Department> department = departmentDao.findById(deptId);
		
		return !(department.isPresent());
	}

	@Override
	public boolean removePatient(Integer patientId) {

		patientDao.deleteById(patientId);
		Optional<PatientDetails> patientDetails = patientDao.findById(patientId);
		
		
		return !(patientDetails.isPresent());
	}

}
