package com.cg.mHealthSystem.RepositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mHealthSystem.Repository.PatientDetailsRepository;

import com.cg.mHealthSystem.entity.PatientDetails;


import static org.assertj.core.api.Assertions.assertThat;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PatientDetailsRepositoryTest {
	@Autowired
	private PatientDetailsRepository pdao;
	@Autowired
    private TestEntityManager testEntityManager;
	
	@Test
	public void testNewAppointment() throws Exception
	{
		PatientDetails patientdetails = getPatientDetails();
		PatientDetails saveInDb = testEntityManager.persist(patientdetails);
		PatientDetails getFromInDb = pdao.findById(saveInDb.getPatientId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
				
	}
	
	@Test
	public void testGetAllPatientDetails() throws Exception
	{
		PatientDetails patientdetails1 = new PatientDetails();
		patientdetails1.setCity("jaipur");
		patientdetails1.setDateOfBirth("30-10-1998");
		patientdetails1.setFirstName("Ayush");
		patientdetails1.setGender("Male");
		patientdetails1.setLastName("Ranjan");
		patientdetails1.setIdProof("adhar number ");
		patientdetails1.setPatientId(101);
		patientdetails1.setPincode("829107");
		patientdetails1.setMiddleName("kumar ");
		patientdetails1.setPhoneNo("8080707077");
		patientdetails1.setState("Rajasthan");
		patientdetails1.setUserId(301);
		patientdetails1.setStreet("dhami kalan");
		patientdetails1.setRecordId(701);
		
		PatientDetails patientdetails2 = new PatientDetails();
		patientdetails2.setCity("bokaro");
		patientdetails2.setDateOfBirth("30-11-1998");
		patientdetails2.setFirstName("Ayushi");
		patientdetails2.setGender("Female");
		patientdetails2.setLastName("Agrawal");
		patientdetails2.setIdProof("adhar number ");
		patientdetails2.setPatientId(102);
		patientdetails2.setPincode("303007");
		patientdetails2.setMiddleName("kumari ");
		patientdetails2.setPhoneNo("872382983");
		patientdetails2.setState("Jharkhand");
		patientdetails2.setUserId(302);
		patientdetails2.setStreet("BTPS");
		patientdetails2.setRecordId(702);
		
		testEntityManager.persist(patientdetails1);
        testEntityManager.persist(patientdetails2);
        
        List<PatientDetails> List = (List<PatientDetails>) pdao.findAll();
        Assert.assertEquals(2,  List.size());
	}
	@Test
	public void testDeleteAppointmentById() throws Exception{
		PatientDetails patientdetails1 = new PatientDetails();
		patientdetails1.setCity("jaipur");
		patientdetails1.setDateOfBirth("30-10-1998");
		patientdetails1.setFirstName("Ayush");
		patientdetails1.setGender("Male");
		patientdetails1.setLastName("Ranjan");
		patientdetails1.setIdProof("adhar number ");
		patientdetails1.setPatientId(101);
		patientdetails1.setPincode("829107");
		patientdetails1.setMiddleName("kumar ");
		patientdetails1.setPhoneNo("8080707077");
		patientdetails1.setState("Rajasthan");
		patientdetails1.setUserId(301);
		patientdetails1.setStreet("dhami kalan");
		patientdetails1.setRecordId(701);
		
		PatientDetails patientdetails2 = new PatientDetails();
		patientdetails2.setCity("bokaro");
		patientdetails2.setDateOfBirth("30-11-1998");
		patientdetails2.setFirstName("Ayushi");
		patientdetails2.setGender("Female");
		patientdetails2.setLastName("Agrawal");
		patientdetails2.setIdProof("adhar number ");
		patientdetails2.setPatientId(102);
		patientdetails2.setPincode("303007");
		patientdetails2.setMiddleName("kumari ");
		patientdetails2.setPhoneNo("872382983");
		patientdetails2.setState("Jharkhand");
		patientdetails2.setUserId(302);
		patientdetails2.setStreet("BTPS");
		patientdetails2.setRecordId(702);
		
		PatientDetails patientdetails = testEntityManager.persist(patientdetails1);
        testEntityManager.persist(patientdetails2);
        
        testEntityManager.remove(patientdetails);
        List<PatientDetails> List = (List<PatientDetails>) pdao.findAll();
        Assert.assertEquals(List.size(), 1);
	}
	@Test
	public void testUpdateAppointment()
	{
		PatientDetails patientdetails2 = new PatientDetails();
		patientdetails2.setCity("bokaro");
		patientdetails2.setDateOfBirth("30-11-1998");
		patientdetails2.setFirstName("Ayushi");
		patientdetails2.setGender("Female");
		patientdetails2.setLastName("Agrawal");
		patientdetails2.setIdProof("adhar number ");
		patientdetails2.setPatientId(102);
		patientdetails2.setPincode("303007");
		patientdetails2.setMiddleName("kumari ");
		patientdetails2.setPhoneNo("872382983");
		patientdetails2.setState("Jharkhand");
		patientdetails2.setUserId(302);
		patientdetails2.setStreet("BTPS");
		patientdetails2.setRecordId(702);
		 testEntityManager.persist(patientdetails2);
		 PatientDetails getFromDb = pdao.findById(102).get();  
		 getFromDb.setStreet("Govindpur");
		 testEntityManager.persist(getFromDb);
		 assertThat(getFromDb.getStreet()).isEqualTo("Govindpur");
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private PatientDetails getPatientDetails() {
		// TODO Auto-generated method stub
		PatientDetails patientdetails = new PatientDetails();
		patientdetails.setCity("jaipur");
		patientdetails.setDateOfBirth("30-10-1998");
		patientdetails.setFirstName("Ayush");
		patientdetails.setGender("Male");
		patientdetails.setLastName("Ranjan");
		patientdetails.setIdProof("adhar number ");
		patientdetails.setPatientId(101);
		patientdetails.setPincode("829107");
		patientdetails.setMiddleName("kumar ");
		patientdetails.setPhoneNo("8080707077");
		patientdetails.setState("Rajasthan");
		patientdetails.setUserId(301);
		patientdetails.setStreet("dhami kalan");
		patientdetails.setRecordId(701);
		return patientdetails;
		
	}
	

}
