package com.cg.mHealthSystem.RepositoryTest;

 import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mHealthSystem.Repository.RolesRepository;
import com.cg.mHealthSystem.entity.Roles;

import junit.framework.Assert;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RolesRepositoryTest {
	@Autowired
	private RolesRepository adao;

	@Autowired
    private TestEntityManager testEntityManager;
	@Test
	public void testNewAppointment() throws Exception
	{
		Roles role = getRole();
		Roles saveInDb = testEntityManager.persist(role);
		Roles getFromInDb = adao.findById(saveInDb.getRoleId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
				
	}
	
	
	
	@Test
	public void testGetAllRoles() throws Exception
	{
		Roles role1 = new Roles();
		role1.setRoleId(101);
		role1.setRoleName("Raju");
		
		
		Roles role2 = new Roles();
		role2.setRoleId(102);
		role2.setRoleName("Ram");
				
		testEntityManager.persist(role1);
        testEntityManager.persist(role2);
        
        List<Roles> List = (List<Roles>) adao.findAll();
        Assert.assertEquals(2, List.size());
	}
	
	
	public Roles getRole() {
		// TODO Auto-generated method stub
		
		Roles role = new Roles();
		role.setRoleId(101);
		role.setRoleName("Raju");
		return role;
	}
	@Test
	public void testDeleteRoleById() throws Exception{
		Roles role1 = new Roles();
		role1.setRoleId(101);
		role1.setRoleName("Raju");
		
		Roles role2 = new Roles();
		role2.setRoleId(102);
		role2.setRoleName("Ram");
		
		
		
		Roles role = testEntityManager.persist(role1);
        testEntityManager.persist(role2);
        
        testEntityManager.remove(role);
        List<Roles> tickets = (List<Roles>) adao.findAll();
        Assert.assertEquals(tickets.size(), 1);
	}
	@Test
	public void testUpdateRole()
	{
		Roles role2 = new Roles();
		role2.setRoleId(102);
		role2.setRoleName("Ram");
		
		testEntityManager.persist(role2);
		Roles getFromDb = adao.findById(102).get();
		getFromDb.setRoleName("Sam");
		testEntityManager.persist(getFromDb);
		assertThat(getFromDb.getRoleName()).isEqualTo("Sam");
		
	}
}
