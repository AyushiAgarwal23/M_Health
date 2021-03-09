package com.cg.mHealthSystem.EntityTest;



import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mHealthSystem.Repository.AppointmentsRepository;
import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.services.AppointmentService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentServiceTest {
	@MockBean
	private AppointmentsRepository adao;
	
	@Autowired
	private AppointmentService aservice ;
	
	@Test
	public void TestCreateAppointment() throws Exception
	{
		Appointments appointment = new Appointments();
		appointment.setAppointmentId(101);
		appointment.setCreatedAt("06-03-2021");
		appointment.setDoctorId(701);
		appointment.setPatientId(501);
		appointment.setEndTime("8 pm ");
		appointment.setDeletedAt("null");
		appointment.setStartTime("7 pm ");

		Mockito.when(adao.save(appointment)).thenReturn(appointment);
		
	}
	
	

}
