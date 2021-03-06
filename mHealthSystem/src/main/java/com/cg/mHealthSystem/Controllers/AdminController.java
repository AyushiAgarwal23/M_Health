package com.cg.mHealthSystem.Controllers;
/**
 * 
 * @author ayushranjan
 * 
 * This is the Admin controller class 
 * 
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mHealthSystem.Exception.ResourceNotFoundException;
import com.cg.mHealthSystem.Repository.DepartmentRepository;
import com.cg.mHealthSystem.Repository.DoctorRepository;
import com.cg.mHealthSystem.Repository.NurseRepository;
import com.cg.mHealthSystem.Repository.PatientDetailsRepository;
import com.cg.mHealthSystem.entity.Department;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.entity.PatientDetails;
import com.cg.mHealthSystem.services.AdminService;

/**
 * 
 * 
 * @author ayushranjan
 *
 *This is the Admin Controller Class 
 */

@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {
	@Autowired
	private AdminService adminservice ;
	

	private static final Logger logger=LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private  DoctorRepository  doctorDao;
	@Autowired
	private NurseRepository nurseDao;
	
	@Autowired
	private DepartmentRepository departmentDao ;
	
	@Autowired
	private PatientDetailsRepository patientDao;

	
	@PostMapping("/addDoctor")
	public Doctor addDoctor(@Valid @RequestBody Doctor doctor )
	{
		logger.info("In admin controller, add doctors method");
		return adminservice.addDoctor(doctor);
	}
	
	@PostMapping("/addNurse")
	public Nurse addNurse(@Valid @RequestBody Nurse nurse )
	{
		logger.info("In admin controller, add Nurse method");
		return adminservice.addNurse(nurse);
	}
	@DeleteMapping("/deleteNurse/{nurseId}")
	public boolean deleteNurse(@PathVariable @Pattern(regexp="[0-9]+")Integer nurseId)
	{

		logger.info("In admin controller, delete nurse method");
		

		Optional<Nurse> nurse = nurseDao.findById(nurseId);
		if(nurse.isPresent())
		{
			return adminservice.removeNurseById(nurseId);
		}
		else
		{
			throw new ResourceNotFoundException();
		}
		
		

	}
	@DeleteMapping("/deleteDoctor/{doctorId}")
	public boolean deleteDoctor(@PathVariable Integer doctorId)
	{

		logger.info("In admin controller, delete doctors method");
		
		Optional<Doctor> doctor = doctorDao.findById(doctorId);
		if(doctor.isPresent())
		{
			return adminservice.removeDoctorById(doctorId);
		}
		throw new ResourceNotFoundException();

	}
	
	@PostMapping("/addDepartment")
	public Department addDepartment(@Valid @RequestBody Department department)
	{
		logger.info("In admin controller, add department method");
		return adminservice.addDepartment(department);
	}
	
	@DeleteMapping("/deleteDepartment/{deptId}")
	public boolean deleteDepartment(@PathVariable Integer deptId)
	{

		logger.info("In admin controller, delete department method");
		
		Optional<Department> department = departmentDao.findById(deptId);
		if(department.isPresent())
		{
			return adminservice.removeDepartment(deptId);
		}
		
		throw new ResourceNotFoundException();

	}
	
	@DeleteMapping("/deletePatient/{patientId}")
	public boolean deletePatient(@PathVariable Integer patientId)
	{

		logger.info("In admin controller, delete Patient method");
		
		
		Optional<PatientDetails> patient =  patientDao.findById(patientId);
		
		if(patient.isPresent())
		{
			return adminservice.removePatient(patientId);
		}
		
		throw new ResourceNotFoundException();
		
	}
	


}
