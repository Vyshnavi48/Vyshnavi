package com.example.demo.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeDataException;
import com.example.demo.repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee e) throws EmployeeDataException {
		Employee emp = repository.findById(e.getId()).orElse(null);
		if(emp==null) {
		return repository.save(e);
		}else
			throw new EmployeeDataException("Employee data already in database!!");
	}
	
	public List<Employee>getEmployee(){
		return repository.findAll();
	}
	public List<Employee> getAllEmployeesDescendingOrderbysalary(){
		List<Employee>list=repository.findAll();
		list.sort(new Comparator() {
			public int Compare(Employee o1,Employee o2) {
				if(o2.getSalary()==o1.getSalary()) {
					return o1.getName().compareTo(o2.getName());
					
				}
				return (int)(o2.getSalary()-o1.getSalary());
			}

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}

		
		});
		return list;
		
		}
	
	public String updateEmployeeBySalary(String salary , Employee e) {
		repository.save(e);
		return "updated successfully";
	}

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	

	
	

}
