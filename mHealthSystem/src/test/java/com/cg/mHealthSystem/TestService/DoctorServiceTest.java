package com.cg.mHealthSystem.TestService;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mHealthSystem.Repository.AppointmentsRepository;
import com.cg.mHealthSystem.Repository.DoctorRepository;
import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Department;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Employee;
import com.cg.mHealthSystem.services.DoctorService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorServiceTest {
	@MockBean
	private DoctorRepository doctorDao;
	
	@Autowired
	private DoctorService doctorservice;
	@MockBean
	private AppointmentsRepository appointmentDao;
	
	@Test
	public void TestAddDoctor()
	{
		Doctor doctor = new Doctor();
		doctor.setConsultingFee(2000);
		doctor.setDoctorId(101);
		Department department = new Department();
		department.setDeptId(69);
		department.setDeptName("gyno");
		department.setEmailId("rajsingh@gmail.com");
		department.setPhoneNo("888151");
		doctor.setDepartment(department);
		Appointments appointments = new Appointments();
		appointments.setAppointmentId(698);
		doctor.setAppointments(appointments);
		Employee employee = new Employee();
		employee.setFirstName("Hans");
		employee.setLastName("Raj");
		doctor.setEmployee(employee);
		
		 Mockito.when(doctorDao.save(doctor)).thenReturn(doctor);
	        assertThat(doctorservice.addDoctor(doctor)).isEqualTo(doctor);
		
	}

}
