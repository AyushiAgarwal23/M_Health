package com.cg.mHealthSystem.RepositoryTest;



//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import com.cg.mHealthSystem.Repository.UserRepository;

import com.cg.mHealthSystem.entity.User;

import junit.framework.Assert;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository adao;

	@Autowired
    private TestEntityManager testEntityManager;
	@Test
	public void testNewUser() throws Exception
	{
		User user = getUser();
		User saveInDb = testEntityManager.persist(user);
		User getFromInDb = adao.findById(saveInDb.getUserId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
				
	}
	public User getUser() {
		// TODO Auto-generated method stub
		
		User user = new User();
		//user.setRoleId(1234);
		user.setUserId(4321);
		user.setPassword("apple");
		user.setEmailId("raj@gmail.com");
		user.setFirstName("Raj");
		
		return user;
	}
	
	@Test
	public void testGetAllUsers() throws Exception 
	{
		User user1  = new User();
		
		//user1.setRoleId(4545);
		user1.setUserId(4961);
		user1.setPassword("ap9ple");
		user1.setEmailId("raj@gmail9.com");
		user1.setFirstName("Raj9");
		
        User user2  = new User();
		
		//user2.setRoleId(4845);
		user2.setUserId(4881);
		user2.setPassword("ap98ple");
		user2.setEmailId("raj@gmail98.com");
		user2.setFirstName("Raj8");
		
		testEntityManager.persist(user1);
        testEntityManager.persist(user2);
        
        List<User> List = (List<User>) adao.findAll();
        Assert.assertEquals(2,  List.size());
	}
	
	@Test
	public void testDeleteUserById() throws Exception{
		
		User user1  = new User();
		
		//user1.setRoleId(4545);
		user1.setUserId(4961);
		user1.setPassword("ap9ple");
		user1.setEmailId("raj@gmail9.com");
		user1.setFirstName("Raj9");
		
        User user2  = new User();
		
		//user2.setRoleId(4845);
		user2.setUserId(4881);
		user2.setPassword("ap98ple");
		user2.setEmailId("raj@gmail98.com");
		user2.setFirstName("Raj8");
		
		User user = testEntityManager.persist(user1);
        testEntityManager.persist(user2);
        
        testEntityManager.remove(user);
        List<User> tickets = (List<User>) adao.findAll();
        Assert.assertEquals(tickets.size(), 1);
		
		
	}
	
	@Test
	public void testUpdateUserPassword()
	{
        User user1  = new User();
		
		//user1.setRoleId(4545);
		user1.setUserId(4961);
		user1.setPassword("ap9ple");
		user1.setEmailId("raj@gmail9.com");
		user1.setFirstName("Raj9");
		
		testEntityManager.persist(user1);
		User getFromDb = adao.findById(4961).get();
		getFromDb.setPassword("NewPassword");
		testEntityManager.persist(getFromDb);
		assertThat(getFromDb.getPassword()).isEqualTo("NewPassword");
		
	}
}
