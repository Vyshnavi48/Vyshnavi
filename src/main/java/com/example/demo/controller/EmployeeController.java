package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeDataException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
    @GetMapping("/all")
	public List<Employee> findAllEmployees(){
		return employeeService.getEmployees();
	}
    @PostMapping("/save")
    public Employee addEmployee(@RequestBody Employee employee) throws EmployeeDataException {
    	return employeeService.saveEmployee(employee);
    }
    @PutMapping("/update/{salary}")
    public String updateEmployeeBySalary(@PathVariable String salary ,@RequestBody Employee e) {
    	return employeeService.updateEmployeeBySalary(salary, e );
    }
}
