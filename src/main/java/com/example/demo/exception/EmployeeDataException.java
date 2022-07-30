package com.example.demo.exception;

public class EmployeeDataException extends RuntimeException {
     private String message;
     public EmployeeDataException() {}
	public EmployeeDataException(String message) {
		super(message);
		this.message=message;
	}

}
