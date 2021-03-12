package com.cg.mHealthSystem.RepositoryTest;



//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mHealthSystem.Repository.AppointmentsRepository;
import com.cg.mHealthSystem.entity.Appointments;

import junit.framework.Assert;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author ayushranjan
 *
 * AppointmentRepository Test cases 
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppointmentRepositoryTest {
	@Autowired
	private AppointmentsRepository adao;

	@Autowired
    private TestEntityManager testEntityManager;
	@Test
	
/**
 * 	Testing for adding new appointment 
 * 
 */
	public void testNewAppointment() throws Exception
	{
		Appointments appointment = getAppointment();
		Appointments saveInDb = testEntityManager.persist(appointment);
		Appointments getFromInDb = adao.findById(saveInDb.getAppointmentId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
				
	}
/**
 * 
 * Testing for getting all appointment 
 */
	
	@Test
	public void testGetAllAppointmnets() throws Exception
	{
		Appointments appointment1 = new Appointments();
		appointment1.setAppointmentId(101);
		appointment1.setCreatedAt("06-03-2021");
		appointment1.setDoctorId(701);
		appointment1.setPatientId(501);
		appointment1.setEndTime("8 pm ");
		appointment1.setDeletedAt("null");
		appointment1.setStartTime("7 pm ");
		
		Appointments appointment2 = new Appointments();
		appointment2.setAppointmentId(103);
		appointment2.setCreatedAt("07-03-2021");
		appointment2.setDoctorId(703);
		appointment2.setPatientId(502);
		appointment2.setEndTime("8 pm ");
		appointment2.setDeletedAt("null");
		appointment2.setStartTime("7 pm ");
		
		testEntityManager.persist(appointment1);
        testEntityManager.persist(appointment2);
        
        List<Appointments> List = (List<Appointments>) adao.findAll();
        Assert.assertEquals(2,  List.size());
	}
	
/**
 * 
 * function for returning  an Appointment  
 */
	
	public Appointments getAppointment() {
		Appointments appointment = new Appointments();
		appointment.setAppointmentId(101);
		appointment.setCreatedAt("06-03-2021");
		appointment.setDoctorId(701);
		appointment.setPatientId(501);
		appointment.setEndTime("8 pm ");
		appointment.setDeletedAt("null");
		appointment.setStartTime("7 pm ");
		return appointment;
	}
/**
 * 	
 * Testing for deleting an appointment 
 */
	
	@Test
	public void testDeleteAppointmentById() throws Exception{
		Appointments appointment1 = new Appointments();
		appointment1.setAppointmentId(101);
		appointment1.setCreatedAt("06-03-2021");
		appointment1.setDoctorId(701);
		appointment1.setPatientId(501);
		appointment1.setEndTime("8 pm ");
		appointment1.setDeletedAt("null");
		appointment1.setStartTime("7 pm ");
		
		Appointments appointment2 = new Appointments();
		appointment2.setAppointmentId(103);
		appointment2.setCreatedAt("07-03-2021");
		appointment2.setDoctorId(703);
		appointment2.setPatientId(502);
		appointment2.setEndTime("8 pm ");
		appointment2.setDeletedAt("null");
		appointment2.setStartTime("7 pm ");
		
		Appointments appointment = testEntityManager.persist(appointment1);
        testEntityManager.persist(appointment2);
        
        testEntityManager.remove(appointment);
        List<Appointments> tickets = (List<Appointments>) adao.findAll();
        Assert.assertEquals(tickets.size(), 1);
	}
	
/**
 * testing for updating Appointment 
 * 	
 */
	@Test
	public void testUpdateAppointment()
	{
		Appointments appointment2 = new Appointments();
		appointment2.setAppointmentId(103);
		appointment2.setCreatedAt("07-03-2021");
		appointment2.setDoctorId(703);
		appointment2.setPatientId(502);
		appointment2.setEndTime("8 pm ");
		appointment2.setDeletedAt("null");
		appointment2.setStartTime("7 pm ");
		testEntityManager.persist(appointment2);
		Appointments getFromDb = adao.findById(103).get();
		getFromDb.setStartTime("10 am ");
		getFromDb.setEndTime("12am");
		testEntityManager.persist(getFromDb);
		assertThat(getFromDb.getEndTime()).isEqualTo("12am");
		
	}
}
