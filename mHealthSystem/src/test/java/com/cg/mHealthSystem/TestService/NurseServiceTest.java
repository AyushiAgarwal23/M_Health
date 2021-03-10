package com.cg.mHealthSystem.TestService;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mHealthSystem.Repository.NurseRepository;
import com.cg.mHealthSystem.entity.Employee;
import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.services.NurseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NurseServiceTest {
	
	@MockBean
	private NurseRepository nurseDao;
	
	@Autowired
	private NurseService nurseservice;
	
	//
	@Test
	public void TestAddNurse()
	{
		Nurse nurse = new Nurse();
		Employee employee = new Employee();
		employee.setEmpId(77);
		employee.setFirstName("aarti");
		employee.setLastName("singh");
		nurse.setEmployee(employee);
		nurse.setNurseFee(20000);
		nurse.setNurseId(101);
		nurse.setUserId(203);
		Mockito.when(nurseDao.save(nurse)).thenReturn(nurse);
        assertThat(nurseservice.addNurse(nurse)).isEqualTo(nurse);
	}
	@Test
	public void TestUpdateNurse()
	{
        Nurse nurse = new Nurse();
        
        nurse.setNurseId(2020);
        Employee employee = new Employee();
        employee.setEmpId(2050);
        nurse.setEmployee(employee);
        
        nurseDao.save(nurse);
        System.out.println(nurse);
    
        nurse.setNurseFee(6000);
    
        System.out.println(nurse.getNurseFee());
        Assert.assertTrue(nurse.getNurseFee().equals(6000));
	}


}