package com.cg.mHealthSystem.TestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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


import com.cg.mHealthSystem.Controllers.AdminController;
import com.cg.mHealthSystem.Controllers.PatientController;
import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Department;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Employee;
import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.entity.PatientDetails;
import com.cg.mHealthSystem.entity.PatientRecords;
import com.cg.mHealthSystem.services.AdminService;
import com.cg.mHealthSystem.services.PatientService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PatientController.class)

public class PatientControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private PatientService patientservice ;
	
//Get all doctors	
	 @Test
	    public void testGetAllDoctors() throws Exception{
		 
	        String url = "/patient/getAllDoctors";
	        Doctor doctor1 = new Doctor();
	        doctor1.setDoctorId(101);
	        Employee employee1=new Employee();
	        employee1.setEmpId(100);
	        employee1.setFirstName("ayush");
			employee1.setLastName("Ranjan");
	        doctor1.setEmployee(employee1);
	        Appointments app=new Appointments();
	        app.setAppointmentId(200);
	        doctor1.setAppointments(app);
	        doctor1.setConsultingFee(10000);
	        Department department = new Department();
			department.setDeptId(69);
			department.setDeptName("gyno");
			department.setEmailId("ayush@gmail.com");
			department.setPhoneNo("221151");
			doctor1.setDepartment(department);
	        
	        
	      
	   Doctor doctor2 = new Doctor();
	        doctor2.setDoctorId(102);
	        Employee employee2=new Employee();
	        employee2.setEmpId(200);
	        employee2.setFirstName("ayushi");
			employee2.setLastName("agarwal");
	        doctor2.setEmployee(employee2);
	        Appointments app2=new Appointments();
	        app2.setAppointmentId(300);
	        doctor2.setAppointments(app2);
	        doctor2.setConsultingFee(20000);
	        Department department2 = new Department();
			department2.setDeptId(69);
			department2.setDeptName("zzz");
			department2.setEmailId("ayushi@gmail.com");
			department2.setPhoneNo("11111");
			doctor2.setDepartment(department);

			List<Doctor> doctorList = new ArrayList<>();
			doctorList.add(doctor1);
			doctorList.add(doctor2);

	        String jsonInput = this.converttoJson(doctorList);

	        Mockito.when(patientservice.getAllDoctors()).thenReturn(doctorList);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();

	        assertThat(jsonInput).isEqualTo(jsonOutput);
		}
	 
//Get all nurses	
		 @Test
		    public void testGetAllNurse() throws Exception{
		        String URI = "/patient/getAllNurse";
		        Nurse nurse1 = new Nurse();
		        nurse1.setUserId(100);
		        nurse1.setNurseId(200);
		        nurse1.setNurseFee(10000);
		        Employee employee1=new Employee();
		        employee1.setEmpId(100);
		        nurse1.setEmployee(employee1);
		        
		        Nurse nurse2 = new Nurse();
		        nurse2.setUserId(900);
		        nurse2.setNurseId(800);
		        nurse2.setNurseFee(90000);
		        Employee employee2=new Employee();
		        employee2.setEmpId(200);
		        nurse2.setEmployee(employee2);
		       
		        List<Nurse> NurseList = new ArrayList<>();
		        NurseList.add(nurse1);
		        NurseList.add(nurse2);
		     

		        String jsonInput = this.converttoJson(NurseList);

		        Mockito.when(patientservice.getAllNurse()).thenReturn(NurseList);
		        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		        String jsonOutput = mockHttpServletResponse.getContentAsString();

		        assertThat(jsonInput).isEqualTo(jsonOutput);
		    }

		 
//Update
		 @Test
		    public void testUpdateProfile() throws Exception{

		        String URI = "/patient/updateProfile/{dateOfBirth.+}/patientDetails/{patientId}";
		        PatientDetails patientDetails = new PatientDetails();
		        
		        patientDetails.setPatientId(100);
		        PatientRecords records=new PatientRecords();
		        records.setRecordId(200);
		        records.setPatientId(300);
		        records.setPrescription("Hello");
		        records.setHealthComplication("Serious Problem");
		        patientDetails.setPatientrecords(records);
		        Appointments app= new Appointments();
		        app.setAppointmentId(900);
		        patientDetails.setAppointment(app);
		        patientDetails.setCity("Jabalpur");
		        patientDetails.setFirstName("Ayushi");
		        
		      
		        String jsonInput = this.converttoJson(patientDetails);

		        Mockito.when(patientservice.updateProfile(Mockito.any(),Mockito.anyString())).thenReturn(patientDetails);
		        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, "\"1.1.1990\"",100).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
		                .andReturn();
		        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		        String jsonOutput = mockHttpServletResponse.getContentAsString();

		        assertThat(jsonInput).isEqualTo(jsonOutput);
		    }
	
 //view by id
		 @Test
			public void testViewById() throws Exception
			{
				String url = "/patient/ViewById/{appointmentId}";
				Appointments appointment = new Appointments();
				appointment.setAppointmentId(100);
				appointment.setDoctorId(200);
				appointment.setPatientId(300);
				appointment.setCreatedAt("1.1.2020");
				appointment.setDeletedAt("2.2.2020");
				appointment.setStartTime("7pm");
				
				
				
				String jsonInput = this.converttoJson(appointment);
				
				Mockito.when(patientservice.viewById(Mockito.any())).thenReturn(appointment);
				 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(url,100).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
			                .andReturn();
			        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
			        String jsonOutput = mockHttpServletResponse.getContentAsString();
			        assertThat(jsonInput).isEqualTo(jsonOutput);
			        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
			}
	

// Book by ID 
			@Test
				public void testBookById() throws Exception
					{
						String url = "/patient/bookById";
						Appointments appointment = new Appointments();
						appointment.setAppointmentId(100);
						appointment.setDoctorId(200);
						appointment.setPatientId(300);
						appointment.setCreatedAt("1.1.2020");
						appointment.setDeletedAt("2.2.2020");
						appointment.setStartTime("7pm");
						
						
						
						String jsonInput = this.converttoJson(appointment);
						
						Mockito.when(patientservice.bookbyId(Mockito.any(Appointments.class))).thenReturn(appointment);
						 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(url).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
					                .andReturn();
					        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
					        String jsonOutput = mockHttpServletResponse.getContentAsString();
					        System.out.println(jsonOutput);
					        assertThat(jsonInput).isEqualTo(jsonOutput);
					        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
					}

				 
//Get by patient detail
	/*	 @Test
		    public void testRetreivePatientRecordById() throws Exception{
		        String URI= "/patient/retreivePatientRecordById/{recordId}";
		        PatientRecords records  = new PatientRecords();
		        records.setRecordId(200);
		        records.setPatientId(300);
		        records.setPrescription("Hello");
		        records.setHealthComplication("Serious Problem");
		        
		        
		        
		        String jsonInput = this.converttoJson(records);
				
		        
		        Mockito.when(patientservice.retreivePatientRecordById(Mockito.any())).thenReturn(records);
				 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI,200).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
			                .andReturn();
			        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
			        String jsonOutput = mockHttpServletResponse.getContentAsString();
			        assertThat(jsonInput).isEqualTo(jsonOutput);
			        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		        
		        
		/*		Mockito.when(patientservice.retreivePatientRecordById(Mockito.any())).thenReturn(records);
				 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI,200).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
			                .andReturn();
			        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
			        String jsonOutput = mockHttpServletResponse.getContentAsString();
			        assertThat(jsonInput).isEqualTo(jsonOutput);
			        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
			        assertThat(records.getPatientId()).isEqualTo(300);
		        
		/*        String jsonInput = this.converttoJson(records);
		        
		        
		        Mockito.when(patientservice.retreivePatientRecordById(Mockito.any())).thenReturn(records);
				 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI,200).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
			                .andReturn();
			        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
			        String jsonOutput = mockHttpServletResponse.getContentAsString();
			        assertThat(jsonInput).isEqualTo(jsonOutput);
			        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
			        assertThat(records.getPatientId()).isEqualTo(300);

		  /*      Mockito.when(patientservice.getPatientRecordById(Mockito.any())).thenReturn(records);
		        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 200)
		                .accept(MediaType.APPLICATION_JSON))
		                .andReturn();
		        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		        String jsonOutput = mockHttpServletResponse.getContentAsString();
		        System.out.println(jsonOutput);
		        assertThat(jsonInput).isEqualTo(jsonOutput);
		        assertThat(records.getPatientId()).isEqualTo(300);
		 }	    */
	
		 
	 

	 private String converttoJson(Object ticket) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(ticket);
	    }

}
