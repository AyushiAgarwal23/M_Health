package com.cg.mHealthSystem.RepositoryTest;



//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import com.cg.mHealthSystem.Repository.NurseRepository;

import com.cg.mHealthSystem.entity.Nurse;

import junit.framework.Assert;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NurseRepositoryTest {
	@Autowired
	private NurseRepository adao;

	@Autowired
    private TestEntityManager testEntityManager;
	@Test
	public void testNewNurse() throws Exception
	{
		Nurse nurse = getNurse();
		Nurse saveInDb = testEntityManager.persist(nurse);
		Nurse getFromInDb = adao.findById(saveInDb.getNurseId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
				
	}
	public Nurse getNurse() {
		// TODO Auto-generated method stub
		
		Nurse nurse = new Nurse();
		
		nurse.setDeptId(1234);
	//	nurse.setEmpId(4321);
		nurse.setNurseId(7894);
	//	nurse.setUserId(4987);
		nurse.setNurseFee(500);
		
		
		return nurse;
	}
	
	@Test
	public void testGetAllNurses() throws Exception 
	{
        Nurse nurse1 = new Nurse();
		
		nurse1.setDeptId(1234);
//		nurse1.setEmpId(4321);
		nurse1.setNurseId(7894);
//		nurse1.setUserId(4987);
		nurse1.setNurseFee(500);
		
		
        Nurse nurse2 = new Nurse();
		
		nurse2.setDeptId(7777);
	//	nurse2.setEmpId(7778);
		nurse2.setNurseId(8888);
		//nurse2.setUserId(4999);
		nurse2.setNurseFee(500);
		
		
		testEntityManager.persist(nurse1);
        testEntityManager.persist(nurse2);
        
        List<Nurse> List = (List<Nurse>) adao.findAll();
        Assert.assertEquals(2,  List.size());
	}
	
	@Test
	public void testDeleteNurseById() throws Exception{
		
        Nurse nurse1 = new Nurse();
		
		nurse1.setDeptId(1234);
	//	nurse1.setEmpId(4321);
		nurse1.setNurseId(7894);
	//	nurse1.setUserId(4987);
		nurse1.setNurseFee(500);
		
		
        Nurse nurse2 = new Nurse();
		
		nurse2.setDeptId(7777);
	//	nurse2.setEmpId(7778);
		nurse2.setNurseId(8888);
	//	nurse2.setUserId(4999);
		nurse2.setNurseFee(500);
		
		Nurse nurse = testEntityManager.persist(nurse1);
        testEntityManager.persist(nurse2);
        
        testEntityManager.remove(nurse);
        List<Nurse> tickets = (List<Nurse>) adao.findAll();
        Assert.assertEquals(tickets.size(), 1);
		
		
	}
	
	@Test
	public void testUpdateNurseFee()
	{
        Nurse nurse1 = new Nurse();
		
		nurse1.setDeptId(1234);
	//	nurse1.setEmpId(4321);
		nurse1.setNurseId(7894);
	//	nurse1.setUserId(4987);
		nurse1.setNurseFee(500);
		
		testEntityManager.persist(nurse1);
		Nurse getFromDb = adao.findById(7894).get();
		getFromDb.setNurseFee(700);
		testEntityManager.persist(getFromDb);
		assertThat(getFromDb.getNurseFee()).isEqualTo(700);
		
	}
}