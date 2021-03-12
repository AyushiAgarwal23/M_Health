/** 	
    * @author Ayushi
    * 
    * 
    * This is the Class for Testing Employee Repository
    */


package com.cg.mHealthSystem.RepositoryTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mHealthSystem.Repository.EmployeeRepository;
import com.cg.mHealthSystem.entity.Employee;
import com.cg.mHealthSystem.entity.Roles;

import junit.framework.Assert;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {
	@Autowired
	private EmployeeRepository adao;

	@Autowired
    private TestEntityManager testEntityManager;
	@Test
	public void testNewAppointment() throws Exception
	{
		Employee employee = getEmployee();
		Employee saveInDb = testEntityManager.persist(employee);
		Employee getFromInDb = adao.findById(saveInDb.getEmpId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
				
	}
	
	@Test
	public void testGetAllRoles() throws Exception
	{
		
		Employee employee1 = new Employee();
		employee1.setEmpId(101);
		employee1.setFirstName("Raju");
		employee1.setMiddleName("Kumar");
		employee1.setLastName("Bhalla");
		employee1.setMobileNo("9090909090");
		employee1.setGender("Male");
		employee1.setStreet("aaaaaa");
		employee1.setDateOfBirth("1/1/2000");
		employee1.setCity("Jabalpur");
		employee1.setState("MP");
		employee1.setPincode("482001");
		employee1.setIdProof("123456");
	
		Employee employee2 = new Employee();
		employee2.setEmpId(102);
		employee2.setFirstName("Ram");
		employee2.setMiddleName("Veer");
		employee2.setLastName("Singh");
		employee2.setMobileNo("1212121212");
		employee2.setGender("Male");
		employee2.setStreet("bbbbbb");
		employee2.setDateOfBirth("2/2/2000");
		employee2.setCity("Mumbai");
		employee2.setState("Maharashtra");
		employee2.setPincode("908765");
		employee2.setIdProof("222222");
				
		testEntityManager.persist(employee1);
        testEntityManager.persist(employee2);
        
        List<Employee> List = (List<Employee>) adao.findAll();
        Assert.assertEquals(2, List.size());
	}
	
	
	public Employee getEmployee() {
		
		Employee employee = new Employee();
		employee.setEmpId(101);
		employee.setFirstName("Raju");
		employee.setMiddleName("Kumar");
		employee.setLastName("Bhalla");
		employee.setMobileNo("9090909090");
		employee.setGender("Male");
		employee.setStreet("aaaaaa");
		employee.setDateOfBirth("1/1/2000");
		employee.setCity("Jabalpur");
		employee.setState("MP");
		employee.setPincode("482001");
		employee.setIdProof("123456");
		
		return employee;
	}
	
	@Test
	public void testDeleteRoleById() throws Exception{
				
		Employee employee1 = new Employee();
		employee1.setEmpId(101);
		employee1.setFirstName("Raju");
		employee1.setMiddleName("Kumar");
		employee1.setLastName("Bhalla");
		employee1.setMobileNo("9090909090");
		employee1.setGender("Male");
		employee1.setStreet("aaaaaa");
		employee1.setDateOfBirth("1/1/2000");
		employee1.setCity("Jabalpur");
		employee1.setState("MP");
		employee1.setPincode("482001");
		employee1.setIdProof("123456");

		Employee employee2 = new Employee();
		employee2.setEmpId(102);
		employee2.setFirstName("Ram");
		employee2.setMiddleName("Veer");
		employee2.setLastName("Singh");
		employee2.setMobileNo("1212121212");
		employee2.setGender("Male");
		employee2.setStreet("bbbbbb");
		employee2.setDateOfBirth("2/2/2000");
		employee2.setCity("Mumbai");
		employee2.setState("Maharashtra");
		employee2.setPincode("908765");
		employee2.setIdProof("222222");
		
		Employee employee = testEntityManager.persist(employee1);
        testEntityManager.persist(employee2);
        
        testEntityManager.remove(employee);
        List<Employee> tickets = (List<Employee>) adao.findAll();
        Assert.assertEquals(tickets.size(), 1);
	}
	
	@Test
	public void testUpdateRole()
	{
		Employee employee2 = new Employee();
		employee2.setEmpId(102);
		employee2.setFirstName("Ram");
		employee2.setMiddleName("Veer");
		employee2.setLastName("Singh");
		employee2.setMobileNo("1212121212");
		employee2.setGender("Male");
		employee2.setStreet("bbbbbb");
		employee2.setDateOfBirth("2/2/2000");
		employee2.setCity("Mumbai");
		employee2.setState("Maharashtra");
		employee2.setPincode("908765");
		employee2.setIdProof("222222");
		
		testEntityManager.persist(employee2);
		Employee getFromDb = adao.findById(102).get();
		getFromDb.setFirstName("Sam");
		testEntityManager.persist(getFromDb);
		assertThat(getFromDb.getFirstName()).isEqualTo("Sam");
		
	}
	

}
