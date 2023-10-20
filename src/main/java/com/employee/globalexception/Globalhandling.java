package com.employee.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.customexception.IdNotFoundException;
import com.employee.customexception.SalaryNotValidException;

@RestControllerAdvice

public class Globalhandling {
	
 @ExceptionHandler(IdNotFoundException.class) 
 
 public ResponseEntity<Object> idHandling() {
	 return new ResponseEntity<>("Entered ID is invalid", HttpStatus.BAD_REQUEST);
 }
	
 
 @ExceptionHandler(SalaryNotValidException.class)
 
 public ResponseEntity<Object> salaryhandler() {
	     return new ResponseEntity<>("Entered salary is invalid", HttpStatus.BAD_REQUEST); 
 }
 
}
