/** 	
    * @author Ayushi
    * 
    * 
    * This is the Class for Global exception
    */

package com.cg.mHealthSystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException extends Exception {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public String handleResourceNotFound(ResourceNotFoundException e) {
		return e.getMessage();
	}

}
