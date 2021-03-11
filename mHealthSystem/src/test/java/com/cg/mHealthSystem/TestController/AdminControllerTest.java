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
import com.cg.mHealthSystem.Exception.ResourceNotFoundException;
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

@RunWith(SpringRunner.class)
@WebMvcTest(value = AdminController.class)
public class AdminControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private DoctorRepository doctorDao;
	
	@MockBean
	private NurseRepository nurseDao;
	
	@MockBean
	private DepartmentRepository departmentDao;
	
	@MockBean
	private PatientDetailsRepository patientsDao;
	
	@MockBean
	private AdminService adminservice ;
	@Test
	public void testNewDoctor() throws Exception
	{
		String url = "/admin/addDoctor";
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
		String jsonInput = this.converttoJson(doctor);
		
		Mockito.when(adminservice.addDoctor(Mockito.any(Doctor.class))).thenReturn(doctor);
		 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(url).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	@Test
	public void testNewNurse() throws Exception
	{
		String url = "/admin/addNurse";
		Nurse nurse = new Nurse();
		Employee employee = new Employee();
		employee.setEmpId(77);
		employee.setFirstName("ayush");
		employee.setLastName("Ranjan");
		nurse.setEmployee(employee);
		nurse.setNurseFee(20000);
		nurse.setNurseId(101);
		nurse.setUserId(203);
		String jsonInput = this.converttoJson(nurse);
		Mockito.when(adminservice.addNurse(Mockito.any(Nurse.class))).thenReturn(nurse);
		 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(url).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		
		
	}
	
    @Test
    public void testDeleteDoctor() throws Exception{
        String URI = "/admin//deleteDoctor/{doctorId}";
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
		String jsonInput = this.converttoJson(doctor);
		
        
        Mockito.when(adminservice.removeDoctorById(Mockito.any())).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 101).accept(MediaType.
        		APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        Assert.assertEquals(HttpStatus.valueOf("NOT_FOUND").value(), mockHttpServletResponse.getStatus());

    }
    
    @Test
    public void testDeleteNurse() throws Exception{
        String URI = "/admin/deleteNurse/{nurseId}";
       
        Nurse nurse = new Nurse();
		Employee employee = new Employee();
		employee.setEmpId(77);
		employee.setFirstName("ayush");
		employee.setLastName("Ranjan");
		nurse.setEmployee(employee);
		nurse.setNurseFee(20000);
		nurse.setNurseId(101);
		nurse.setUserId(203);
		String jsonInput = this.converttoJson(nurse);
		
		
        
        Mockito.when(adminservice.removeNurseById(Mockito.any())).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 101).accept(MediaType.
        		APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        Assert.assertEquals(HttpStatus.valueOf("NOT_FOUND").value(), mockHttpServletResponse.getStatus());

    }
    
    @Test
	public void testNewDepartment() throws Exception
	{
		String url = "/admin/addDepartment";
		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("gyno");
		department.setEmailId("gynco@capg.com");
		department.setPhoneNo("723875");
		String jsonInput = this.converttoJson(department);
		Mockito.when(adminservice.addDepartment(Mockito.any(Department.class))).thenReturn(department);
		 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(url).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		
		
	}
	
    
    @Test
    public void testDeleteDepartment() throws Exception  {
        String URI = "/admin/deleteDepartment/{deptId}";
        Department  department= new Department();
		department.setDeptId(1);
		department.setDeptName("gyno");
		department.setEmailId("gynco@capg.com");
		department.setPhoneNo("723875");
		String jsonInput = this.converttoJson(department);
		adminservice.addDepartment(department);
		System.out.println(adminservice.findDepartmentById(1));
		Mockito.when(adminservice.findDepartmentById(Mockito.any())).thenReturn(department);
		Mockito.when(adminservice.removeDepartment(Mockito.any())).thenReturn(true);
		 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 1).accept(MediaType.
	        		APPLICATION_JSON)).andReturn();
		 MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		 System.out.println(mockHttpServletResponse.getStatus());
		 System.out.println(HttpStatus.valueOf("NOT_FOUND").value());
		Assert.assertEquals(HttpStatus.valueOf("NOT_FOUND").value(), mockHttpServletResponse.getStatus());
		
		
    }
	@Test
    public void testDeletePatient() throws Exception{
        String URI = "/admin/deletePatient/{patientId}";
        PatientDetails patient = new PatientDetails();
        patient.setUserId(10);
        patient.setFirstName("ayush");
        patient.setLastName("ranjan");
		String jsonInput = this.converttoJson(patient);
        
        Mockito.when(adminservice.removePatient(Mockito.any())).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 10).accept(MediaType.
        		APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        Assert.assertEquals(HttpStatus.valueOf("NOT_FOUND").value(), mockHttpServletResponse.getStatus());

    }
    
    private String converttoJson(Object ticket) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(ticket);
    }

}
