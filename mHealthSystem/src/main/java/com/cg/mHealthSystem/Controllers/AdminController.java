package com.cg.mHealthSystem.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.cg.mHealthSystem.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminservice ;
	
	@Autowired
	private  DoctorRepository  doctorDao;
	@Autowired
	private NurseRepository nurseDao;
	
	@Autowired
	private DepartmentRepository departmentDao ;

	private PatientDetailsRepository patientDao;
	
	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor )
	{
		return adminservice.addDoctor(doctor);
	}
	
	@PostMapping("/addNurse")
	public Nurse addNurse(@RequestBody Nurse nurse )
	{
		return adminservice.addNurse(nurse);
	}
	@DeleteMapping("/deleteNurse/{nurseId}")
	public boolean deleteNurse(@PathVariable Integer nurseId)
	{
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
		return adminservice.removeDoctorById(doctorId);
	}
	
	@PostMapping("/addDepartment")
	public Department addDepartment(@RequestBody Department department)
	{
		return adminservice.addDepartment(department);
	}
	
	@DeleteMapping("/deleteDepartment/{deptId}")
	public boolean deleteDepartment(@PathVariable Integer deptId)
	{
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
		return adminservice.removePatient(patientId);
	}
	


}
