package com.cg.mHealthSystem.RepositoryTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mHealthSystem.Repository.DoctorRepository;

import com.cg.mHealthSystem.entity.Doctor;


import junit.framework.Assert;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest

public class DoctorRepositoryTest {
	@Autowired
	private DoctorRepository adao;

	@Autowired
    private TestEntityManager testEntityManager;
	@Test
	public void testNewAppointment() throws Exception
	{
		Doctor doctor = getDoctor();
		Doctor saveInDb = testEntityManager.persist(doctor);
		Doctor getFromInDb = adao.findById(saveInDb.getDoctorId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
				
	}

	@Test
	public void testGetAllRoles() throws Exception
	{
		
		Doctor doctor1 = new Doctor();
		doctor1.setDoctorId(101);
		//doctor1.setUserId(111);
		//doctor1.setEmpId(11111);
		//doctor1.setDeptId(1010101);
		doctor1.setConsultingFee(5000);
		
		Doctor doctor2 = new Doctor();
		doctor2.setDoctorId(102);
		//doctor2.setUserId(222);
		//doctor2.setEmpId(22222);
		//doctor2.setDeptId(20202020);
		doctor2.setConsultingFee(9000);
		
		testEntityManager.persist(doctor1);
        testEntityManager.persist(doctor2);
        
        List<Doctor> List = (List<Doctor>) adao.findAll();
        Assert.assertEquals(2, List.size());
      }
	public Doctor getDoctor() {
		// TODO Auto-generated method stub
		
		Doctor doctor1 = new Doctor();
		doctor1.setDoctorId(101);
		//doctor1.setUserId(111);
		//doctor1.setEmpId(11111);
		//doctor1.setDeptId(1010101);
		doctor1.setConsultingFee(5000);
		
		return doctor1;
	}
	@Test
	public void testDeleteDoctorById() throws Exception{
		Doctor doctor1 = new Doctor();
		doctor1.setDoctorId(101);
		/*doctor1.setUserId(111);
		doctor1.setEmpId(11111);
		doctor1.setDeptId(1010101);*/
		doctor1.setConsultingFee(5000);
		
		Doctor doctor2 = new Doctor();
		doctor2.setDoctorId(102);
		//doctor2.setUserId(222);
		//doctor2.setEmpId(22222);
		//doctor2.setDeptId(20202020);
		doctor2.setConsultingFee(9000);
		
		Doctor doctor = testEntityManager.persist(doctor1);
        testEntityManager.persist(doctor2);
        
        testEntityManager.remove(doctor);
        List<Doctor> tickets = (List<Doctor>) adao.findAll();
        Assert.assertEquals(tickets.size(), 1);
	}
	
	@Test
	public void testUpdateDoctor()
	{
		Doctor doctor2 = new Doctor();
		doctor2.setDoctorId(102);
		//doctor2.setUserId(222);
		//doctor2.setEmpId(22222);
		//doctor2.setDeptId(20202020);
		doctor2.setConsultingFee(9000);
		testEntityManager.persist(doctor2);
		Doctor getFromDb = adao.findById(102).get();
		//getFromDb.setUserId(999);
		testEntityManager.persist(getFromDb);
		//assertThat(getFromDb.getUserId()).isEqualTo(999);
	}
	
}
