package com.cg.mHealthSystem.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mHealthSystem.entity.Department;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminservice ;
	
	private static final Logger logger=LoggerFactory.getLogger(PatientController.class);
	
	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor )
	{
		logger.info("In admin controller, add doctors method");
		return adminservice.addDoctor(doctor);
	}
	
	@PostMapping("/addNurse")
	public Nurse addNurse(@RequestBody Nurse nurse )
	{
		logger.info("In admin controller, add Nurse method");
		return adminservice.addNurse(nurse);
	}
	@DeleteMapping("/deleteNurse/{nurseId}")
	public boolean deleteNurse(@PathVariable Integer nurseId)
	{
		logger.info("In admin controller, delete nurse method");
		return adminservice.removeNurseById(nurseId);
	}
	@DeleteMapping("/deleteDoctor/{doctorId}")
	public boolean deleteDoctor(@PathVariable Integer doctorId)
	{
		logger.info("In admin controller, delete doctors method");
		return adminservice.removeDoctorById(doctorId);
	}
	
	@PostMapping("/addDepartment")
	public Department addDepartment(@RequestBody Department department)
	{
		logger.info("In admin controller, add department method");
		return adminservice.addDepartment(department);
	}
	
	@DeleteMapping("/deleteDepartment/{deptId}")
	public boolean deleteDepartment(@PathVariable Integer deptId)
	{
		logger.info("In admin controller, delete department method");
		return adminservice.removeDepartment(deptId);
	}
	
	@DeleteMapping("/deletePatient/{patientId}")
	public boolean deletePatient(@PathVariable Integer patientId)
	{
		logger.info("In admin controller, delete Patient method");
		return adminservice.removePatient(patientId);
	}
	


}
