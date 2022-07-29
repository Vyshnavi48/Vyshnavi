package com.example.demo.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee e) {
		return repository.save(e);
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
	

	
	

}
