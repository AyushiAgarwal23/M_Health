/** 	
    * @author Ayushi
    * 
    * 
    * This is the Class for running test Cases
    */

package com.cg.mHealthSystem.TestSuiteCase;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class TestSuiteRunner {
	public static void main(String[] args) {
	      
		  Result result = JUnitCore.runClasses(TestSuiteCase.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful()+" All test Suites Running");
	   }
}
