package com.cg.mHealthSystem.RepositoryTest;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mHealthSystem.Repository.NurseRepository;
import com.cg.mHealthSystem.Repository.PatientRecordsRepository;
import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.entity.PatientRecords;

import junit.framework.Assert;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest

public class PatientRecordsRepositoryTest {
	@Autowired
	private PatientRecordsRepository adao;

	@Autowired
    private TestEntityManager testEntityManager;
	@Test
	public void testNewNurse() throws Exception
	{
		PatientRecords patientRecords = getPatientRecords();
		PatientRecords saveInDb = testEntityManager.persist(patientRecords);
		PatientRecords getFromInDb = adao.findById(saveInDb.getRecordId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
				
	}
	public PatientRecords getPatientRecords() {
		// TODO Auto-generated method stub
		
		PatientRecords patientRecords = new PatientRecords();
		patientRecords.setRecordId(123);
		patientRecords.setPatientId(321);
		patientRecords.setHealthComplication("Headache");
		patientRecords.setPrescription("pcm");
		
		
		
		return patientRecords;
	}
	
	@Test
	public void testGetAllNurses() throws Exception 
	{
		PatientRecords patientRecords1 = new PatientRecords();
		patientRecords1.setRecordId(123);
		patientRecords1.setPatientId(321);
		patientRecords1.setHealthComplication("Headache");
		patientRecords1.setPrescription("pcm");
		
		PatientRecords patientRecords2 = new PatientRecords();
		patientRecords2.setRecordId(153);
		patientRecords2.setPatientId(351);
		patientRecords2.setHealthComplication("eye pain");
		patientRecords2.setPrescription("specs");

		
		
		testEntityManager.persist(patientRecords1);
        testEntityManager.persist(patientRecords2);
        
        List<PatientRecords> List = (List<PatientRecords>) adao.findAll();
        Assert.assertEquals(2,  List.size());
	}
	
	@Test
	public void testDeleteNurseById() throws Exception{
		
		PatientRecords patientRecords1 = new PatientRecords();
		patientRecords1.setRecordId(123);
		patientRecords1.setPatientId(321);
		patientRecords1.setHealthComplication("Headache");
		patientRecords1.setPrescription("pcm");
		
		PatientRecords patientRecords2 = new PatientRecords();
		patientRecords2.setRecordId(153);
		patientRecords2.setPatientId(351);
		patientRecords2.setHealthComplication("eye pain");
		patientRecords2.setPrescription("specs");

		
		PatientRecords patientRecords  = testEntityManager.persist(patientRecords1);
        testEntityManager.persist(patientRecords2);
        
        testEntityManager.remove(patientRecords);
        List<PatientRecords> tickets = (List<PatientRecords>) adao.findAll();
        Assert.assertEquals(tickets.size(), 1);
		
		
	}
	

}
