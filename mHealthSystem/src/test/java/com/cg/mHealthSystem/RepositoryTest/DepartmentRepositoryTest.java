package com.cg.mHealthSystem.RepositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import com.cg.mHealthSystem.Repository.DepartmentRepository;
import com.cg.mHealthSystem.entity.Department;

import junit.framework.Assert;
/**
 * 
 * @author ayushranjan
 *
 *DepartmentRepository Testing class 
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class DepartmentRepositoryTest {
	@Autowired
	private DepartmentRepository ddao;
	
	@Autowired
    private TestEntityManager testEntityManager;
/**
 * 
 * Testing for adding new Department 	
 * 
 */
	@Test
	public void testNewDepartment() throws Exception
	{
		Department department = getDepartment();
		department.setDeptId(19);
		Department saveInDb = testEntityManager.persist(department);
		Department getFromInDb = ddao.findById(saveInDb.getDeptId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
				
	}
	
/**
 * 
 * Testing for getting all department 	
 * 
 */
	@Test
	public void testGetAllDepartments() throws Exception
	{
		Department department1  = new Department();
		department1.setDeptId(101);
		department1.setDeptName("Orthopedic");
		department1.setEmailId("bkjha@gmail.com");
		department1.setPhoneNo("9430245639");
		
		Department department2  = new Department();
		department2.setDeptId(102);
		department2.setDeptName("Psycologist");
		department2.setEmailId("ayush@gmail.com");
		department2.setPhoneNo("8877808070");
		
		testEntityManager.persist(department1);
        testEntityManager.persist(department2);
        
        List<Department> List = (List<Department>) ddao.findAll();
        Assert.assertEquals(2,  List.size());
	}
/**
 * 
 * Testing for deleting an department using ID	
 * 
 */
	@Test
	public void testDeleteDepartmentById() throws Exception{
		Department department1  = new Department();
		department1.setDeptId(101);
		department1.setDeptName("Orthopedic");
		department1.setEmailId("bkjha@gmail.com");
		department1.setPhoneNo("9430245639");
		
		Department department2  = new Department();
		department2.setDeptId(102);
		department2.setDeptName("Psycologist");
		department2.setEmailId("ayush@gmail.com");
		department2.setPhoneNo("8877808070");
		
		Department department= testEntityManager.persist(department1);
        testEntityManager.persist(department2);
        testEntityManager.remove(department);
        List<Department> List = (List<Department>) ddao.findAll();
        Assert.assertEquals(List.size(), 1);
		
	}
	
/**
 * 
 * Testing for updating department . Changing its email id 	
 */
	@Test
	public void testUpdateDepartment()
	{
		
		Department department2  = new Department();
		department2.setDeptId(102);
		department2.setDeptName("Psycologist");
		department2.setEmailId("ayush@gmail.com");
		department2.setPhoneNo("8877808070");
		 testEntityManager.persist(department2);
		 Department getFromDb = ddao.findById(102).get();
		 getFromDb.setEmailId("ayushranjan@gmail.com");
		 testEntityManager.persist(getFromDb);
		assertThat(getFromDb.getEmailId()).isEqualTo("ayushranjan@gmail.com");
	}
	/**
	 * 
	 * Method for returning an department object when called 
	 * 
	 */
	private Department getDepartment() {
		
		
		Department department  = new Department();
		department.setDeptId(101);
		department.setDeptName("Orthopedic");
		department.setEmailId("bkjha@gmail.com");
		department.setPhoneNo("9430245639");
		return department;
	}
	

}
