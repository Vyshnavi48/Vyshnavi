package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(EmployeeDataException.class)
	public  ResponseEntity<?> EmployeeDataExceptionHandling(EmployeeDataException ex, WebRequest request){
		ErrorEntity ee= new ErrorEntity(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(ee, HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<?> globalExceptionHandling(Exception ex, WebRequest request){
		ErrorEntity ee=new ErrorEntity(new Date(), ex.getMessage(), request.getDescription(false)); 
		return new ResponseEntity<>(ee, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
