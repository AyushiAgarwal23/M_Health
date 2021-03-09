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
import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Department;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Employee;
import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.services.AdminService;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
	 
	@MockBean
	private DoctorRepository doctorDao;
	
	@MockBean
	private NurseRepository nurseDao;
	
	@MockBean
	private DepartmentRepository departmentDao;
	@Autowired
	private AdminService adminservice;
	
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
		
        Mockito.when(doctorDao.findById(101).get()).thenReturn(doctor);
        doctorDao.deleteById(doctor.getDoctorId());
        Mockito.when(doctorDao.findById(101).get()).thenReturn(doctor);
        Assert.assertNotEquals(doctor, new Doctor());
        Assert.assertEquals(adminservice.removeDoctorById(101), false);
		
	}
	
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
		
        Mockito.when(nurseDao.findById(101).get()).thenReturn(nurse);
        nurseDao.deleteById(nurse.getNurseId());
        Mockito.when(nurseDao.findById(101).get()).thenReturn(nurse);
        Assert.assertNotEquals(nurse, new Doctor());
        Assert.assertEquals(adminservice.removeNurseById(101), false);
		
	}
	
	
	@Test
	public void TestDeleteDepartmentById() throws Exception
	{
		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("gyno");
		department.setEmailId("gynco@capg.com");
		department.setPhoneNo("723875");
		Mockito.when(departmentDao.save(department)).thenReturn(department);
        Mockito.when(departmentDao.findById(1).get()).thenReturn(department);
        departmentDao.deleteById(department.getDeptId());
        Mockito.when(departmentDao.findById(1).get()).thenReturn(department);
        Assert.assertNotEquals(department, new Department());
        Assert.assertEquals(adminservice.removeDepartment(1), false);
	}
	
	
	
	
	
	
	

}
