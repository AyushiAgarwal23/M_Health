<<<<<<< HEAD
package com.cg.mHealthSystem.TestController;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.mHealthSystem.Controllers.DoctorController;
import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Department;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Employee;
import com.cg.mHealthSystem.entity.PatientRecords;
import com.cg.mHealthSystem.services.DoctorService;
import com.cg.mHealthSystem.services.PatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(value = DoctorController.class)
public class DoctorControllerTest {
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	private DoctorService doctorservice ;
	@Test
	public void testViewAppointment() throws Exception
	{
		String url = "/doctor/viewAppointment/{appointmentId}";
		Appointments appointment = new Appointments();
		appointment.setAppointmentId(100);
		appointment.setDoctorId(200);
		appointment.setPatientId(300);
		appointment.setCreatedAt("1.1.2020");
		appointment.setDeletedAt("2.2.2020");
		appointment.setStartTime("7pm");
		
		//
		
		String jsonInput = this.converttoJson(appointment);
		
		Mockito.when(doctorservice.viewAppointment(Mockito.any())).thenReturn(appointment);
		 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(url,100).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	 private String converttoJson(Object ticket) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(ticket);
	    }
	 
	 
	 @Test
		public void testaddDoctor() throws Exception
		{
			String url = "/doctor/addDoctor";
			Doctor doctor = new Doctor();
			doctor.setConsultingFee(2000);
			doctor.setDoctorId(101);
			Department department = new Department();
			department.setDeptId(69);
			department.setDeptName("gyno");
			department.setEmailId("rajkapoor@gmail.com");
			department.setPhoneNo("221151");
			doctor.setDepartment(department);
			Appointments appointments = new Appointments();
			appointments.setAppointmentId(698);
			doctor.setAppointments(appointments);
			Employee employee = new Employee();
			employee.setFirstName("ayu");
			employee.setLastName("Ram");
			doctor.setEmployee(employee);
			String jsonInput = this.converttoJson(doctor);
			
			Mockito.when(doctorservice.addDoctor(Mockito.any(Doctor.class))).thenReturn(doctor);
			 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(url).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
		                .andReturn();
		        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		        String jsonOutput = mockHttpServletResponse.getContentAsString();
		        assertThat(jsonInput).isEqualTo(jsonOutput);
		        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		}
	 
/*	 @Test
		public void testViewPatientRecord() throws Exception
		{
			String url = "/patient/patientRecord/{patientId}";
			PatientRecords patientrecord = new PatientRecords();
			
			patientrecord.setPatientId(5588);
			patientrecord.setRecordId(45698);
			patientrecord.setHealthComplication("Loveria");
			patientrecord.setPrescription("stop watching rom-com movies");
			
			
			
			String jsonInput = this.converttoJson(patientrecord);
			
			Mockito.when(doctorservice.patientRecord(Mockito.any())).thenReturn(patientrecord);
			 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(url,5588).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
		                .andReturn();
		        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		        String jsonOutput = mockHttpServletResponse.getContentAsString();
		        assertThat(jsonInput).isEqualTo(jsonOutput);
		        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		}
*/

}
=======
package com.cg.mHealthSystem.TestController;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.mHealthSystem.Controllers.DoctorController;
import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Department;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Employee;
import com.cg.mHealthSystem.services.DoctorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(value = DoctorController.class)
public class DoctorControllerTest {
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	private DoctorService doctorservice ;
	@Test
	public void testViewAppointment() throws Exception
	{
		String url = "/doctor/viewAppointment/{appointmentId}";
		Appointments appointment = new Appointments();
		appointment.setAppointmentId(100);
		appointment.setDoctorId(200);
		appointment.setPatientId(300);
		appointment.setCreatedAt("1.1.2020");
		appointment.setDeletedAt("2.2.2020");
		appointment.setStartTime("7pm");
		
		//
		
		String jsonInput = this.converttoJson(appointment);
		
		Mockito.when(doctorservice.viewAppointment(Mockito.any())).thenReturn(appointment);
		 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(url,100).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	 private String converttoJson(Object ticket) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(ticket);
	    }
	 
	 
	 @Test
		public void testaddDoctor() throws Exception
		{
			String url = "/doctor/addDoctor";
			Doctor doctor = new Doctor();
			doctor.setConsultingFee(2000);
			doctor.setDoctorId(101);
			Department department = new Department();
			department.setDeptId(69);
			department.setDeptName("gyno");
			department.setEmailId("rajkapoor@gmail.com");
			department.setPhoneNo("221151");
			doctor.setDepartment(department);
			Appointments appointments = new Appointments();
			appointments.setAppointmentId(698);
			doctor.setAppointments(appointments);
			Employee employee = new Employee();
			employee.setFirstName("ayu");
			employee.setLastName("Ram");
			doctor.setEmployee(employee);
			String jsonInput = this.converttoJson(doctor);
			
			Mockito.when(doctorservice.addDoctor(Mockito.any(Doctor.class))).thenReturn(doctor);
			 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(url).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
		                .andReturn();
		        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		        String jsonOutput = mockHttpServletResponse.getContentAsString();
		        assertThat(jsonInput).isEqualTo(jsonOutput);
		        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		}


}
>>>>>>> a0ba3906b48996bccb17bc520b058f5a73dfa52a
