package com.ds.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Realtime use of AOP
@ControllerAdvice
public class StudentRestExceptionHandler {

	//Add an exception handler using @ExceptionHandler
	//Handling StudentNotFoundException Type exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
		
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage(exception.getMessage());
		studentErrorResponse.setTime(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(studentErrorResponse,HttpStatus.NOT_FOUND);
	}
	
	
	//Handling Generic Exception //Tyep mismatch
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
		
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		studentErrorResponse.setMessage(exception.getMessage());
		studentErrorResponse.setTime(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(studentErrorResponse,HttpStatus.NOT_FOUND);
	}
}
