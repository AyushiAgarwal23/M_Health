package com.cg.mHealthSystem.TestService;

import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mHealthSystem.Repository.DepartmentRepository;
import com.cg.mHealthSystem.Repository.DoctorRepository;
import com.cg.mHealthSystem.Repository.NurseRepository;
import com.cg.mHealthSystem.Repository.PatientDetailsRepository;
import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Department;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Employee;
import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.entity.PatientDetails;
import com.cg.mHealthSystem.services.AdminService;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
/**
 * 
 * @author ayushranjan
 *Admin Controller Service Test Class 
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
	 
	@MockBean
	private DoctorRepository doctorDao;
	
	@MockBean
	private NurseRepository nurseDao;
	
	@MockBean
	private DepartmentRepository departmentDao;
	
	@MockBean
	private PatientDetailsRepository patientsDao;
	@Autowired
	private AdminService adminservice;
/**
 * Testing for adding doctor 	
 */
	@Test
	public void TestAddDoctor()
	{
		Doctor doctor = new Doctor();
		doctor.setConsultingFee(2000);
		doctor.setDoctorId(101);
		Department department = new Department();
		department.setDeptId(69);
		department.setDeptName("gyno");
		department.setEmailId("ayush@gmail.com");
		department.setPhoneNo("221151");
		doctor.setDepartment(department);
		Appointments appointments = new Appointments();
		appointments.setAppointmentId(698);
		doctor.setAppointments(appointments);
		Employee employee = new Employee();
		employee.setFirstName("ayush");
		employee.setLastName("Ranjan");
		doctor.setEmployee(employee);
		
		 Mockito.when(doctorDao.save(doctor)).thenReturn(doctor);
	        assertThat(adminservice.addDoctor(doctor)).isEqualTo(doctor);
		
	}
	
/**
 * Testing for adding a nurse 	
 */
	@Test
	public void TestAddNurse()
	{
		Nurse nurse = new Nurse();
		Employee employee = new Employee();
		employee.setEmpId(77);
		employee.setFirstName("ayush");
		employee.setLastName("Ranjan");
		nurse.setEmployee(employee);
		nurse.setNurseFee(20000);
		nurse.setNurseId(101);
		nurse.setUserId(203);
		Mockito.when(nurseDao.save(nurse)).thenReturn(nurse);
        assertThat(adminservice.addNurse(nurse)).isEqualTo(nurse);
	}
	
/**
 * Testing for adding a department 
 */
	@Test
	public void TestAddDepartment()
	{
		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("gyno");
		department.setEmailId("gynco@capg.com");
		department.setPhoneNo("723875");
		Mockito.when(departmentDao.save(department)).thenReturn(department);
        assertThat(adminservice.addDepartment(department)).isEqualTo(department);
		
	}

/**
 * 	Testing for deleting a doctor by Id 
 */
	@Test
	public void testDeleteDoctorById() throws Exception
	{
		Doctor doctor = new Doctor();
		doctor.setConsultingFee(2000);
		doctor.setDoctorId(101);
		Department department = new Department();
		department.setDeptId(69);
		department.setDeptName("gyno");
		department.setEmailId("ayush@gmail.com");
		department.setPhoneNo("221151");
		doctor.setDepartment(department);
		Appointments appointments = new Appointments();
		appointments.setAppointmentId(698);
		doctor.setAppointments(appointments);
		Employee employee = new Employee();
		employee.setFirstName("ayush");
		employee.setLastName("Ranjan");
		doctor.setEmployee(employee);
		
		Mockito.when(doctorDao.save(doctor)).thenReturn(doctor);
		
		doctorDao.save(doctor);
		doctorDao.deleteById(doctor.getDoctorId());
		Assert.assertEquals(doctorDao.findById(101),Optional.empty());
		
	}
	
/**
 * Testing for deleting a nurse by id 
 */
	@Test
	public void TestDeleteNurseById() throws Exception
	{
		Nurse nurse = new Nurse();
		Employee employee = new Employee();
		employee.setEmpId(77);
		employee.setFirstName("ayush");
		employee.setLastName("Ranjan");
		nurse.setEmployee(employee);
		nurse.setNurseFee(20000);
		nurse.setNurseId(101);
		nurse.setUserId(203);
Mockito.when(nurseDao.save(nurse)).thenReturn(nurse);
		
	nurseDao.save(nurse);
	nurseDao.deleteById(nurse.getNurseId());
	Assert.assertEquals(nurseDao.findById(101),Optional.empty());
		
	}
	
/**
 * testing for deleting a department by id 	
 */
	@Test
	public void TestDeleteDepartmentById() throws Exception
	{
		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("gyno");
		department.setEmailId("gynco@capg.com");
		department.setPhoneNo("723875");
		
		departmentDao.save(department);
        departmentDao.deleteById(department.getDeptId());
       Assert.assertEquals(departmentDao.findById(1),Optional.empty());
       
	}
	
/**
 * Testing for deleting a patient by Id 
 * @throws Exception
 */
	@Test
	public void TestDeletePatientById() throws Exception
	{
		 PatientDetails patient = new PatientDetails();
	        patient.setUserId(10);
	        patient.setFirstName("ayush");
	        patient.setLastName("ranjan");
	        
	        patientsDao.save(patient);
	        patientsDao.deleteById(patient.getPatientId());
	       Assert.assertEquals(patientsDao.findById(10),Optional.empty());
	        
	}
	
	
	
	
	
	
	

}
