
/** 	
    * @author Ayushi
    * 
    * 
    * This is the Class for TestSuite 
    */

package com.cg.mHealthSystem.TestService;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdminServiceTest.class, DoctorServiceTest.class, NurseServiceTest.class, PatientServiceTest.class })
public class AllTests {

}
