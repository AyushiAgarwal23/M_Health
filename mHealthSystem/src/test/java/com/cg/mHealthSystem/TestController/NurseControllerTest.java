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

import com.cg.mHealthSystem.Controllers.NurseController;

import com.cg.mHealthSystem.entity.Employee;
import com.cg.mHealthSystem.entity.Nurse;


import com.cg.mHealthSystem.services.NurseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
@WebMvcTest(value = NurseController.class)
public class NurseControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	private NurseService nurseservice ;
	
	 @Test
	    public void testaddNurse() throws Exception
	    {
		 String url = "/nurse/addNurse";
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
			Mockito.when(nurseservice.addNurse(Mockito.any(Nurse.class))).thenReturn(nurse);
			 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(url).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
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
	 //
	 @Test
	    public void testUpdateNurse() throws Exception{

	        String URI = "/nurse/updateNurse/{nurseFee:.+}/Nurse/{nurseId}";
	        Nurse nurse = new Nurse();
	        
	        nurse.setNurseId(2020);
	        Employee employee = new Employee();
	        employee.setEmpId(2050);
	        nurse.setEmployee(employee);
	        
	      
	        String jsonInput = this.converttoJson(nurse);

	        Mockito.when(nurseservice.updateNurse(Mockito.any(),Mockito.any())).thenReturn(nurse);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,700,2020).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();

	        assertThat(jsonInput).isEqualTo(jsonOutput);
	    }
	


}
