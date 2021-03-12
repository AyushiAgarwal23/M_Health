/** 	
    * @author Ayushi
    * 
    * 
    * This is the Class for Logger
    */

package com.cg.mHealthSystem.Logger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;


@SpringBootApplication
public class logger {
	private static final Logger logger=LoggerFactory.getLogger(logger.class);
	public static void main(String args[]) {
		logger.info("This is a logger message");
		SpringApplication.run(logger.class,args);
		
	}
	

}