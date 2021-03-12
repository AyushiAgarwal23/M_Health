/** 	
    * @author Ayushi
    * 
    * 
    * This is the Class for running test Cases
    */

package com.cg.mHealthSystem.TestSuiteCase;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cg.mHealthSystem.TestController.AdminControllerTest;
import com.cg.mHealthSystem.TestController.DoctorControllerTest;
import com.cg.mHealthSystem.TestController.NurseControllerTest;
import com.cg.mHealthSystem.TestController.PatientControllerTest;
import com.cg.mHealthSystem.TestService.AdminServiceTest;
import com.cg.mHealthSystem.TestService.DoctorServiceTest;
import com.cg.mHealthSystem.TestService.NurseServiceTest;
import com.cg.mHealthSystem.TestService.PatientServiceTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({

	
	@Test
   /** 	
    * @author Ayushi
    */
	PatientControllerTest.class,
	PatientServiceTest.class,
	
	 /** 	
	    * @author Ayush
	    */
	AdminControllerTest.class,
	AdminServiceTest.class,
	
	/** 	
	    * @author Vivek
	    */
	
	DoctorControllerTest.class,
	DoctorServiceTest.class,
	
	NurseControllerTest.class,
	NurseServiceTest.class,
	

	
	
})

public class TestSuiteCase {

}
