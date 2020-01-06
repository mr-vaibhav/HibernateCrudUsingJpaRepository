package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.AccountRepository;
import com.example.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	public void createEmployee(Employee employee) {
		
		employeeRepository.save(employee);
		
	}
	
	public List<Employee> employeeList(){
		return employeeRepository.findAll();
	}
	
	public  ResponseEntity<Object> updateEmployee(Employee employee,Integer id) {
		
		Optional<Employee> newEmployee = employeeRepository.findById(id);
		if(!newEmployee.isPresent())
			return ResponseEntity.notFound().build();
		employee.setEmployeeId(id);
		employeeRepository.save(employee);
		return ResponseEntity.noContent().build();
	}
	
	public void deleteEmployeeById(Integer id) {
		  employeeRepository.deleteById(id);	  
	}

	public Optional<Employee> searchEmployeeById(Integer id) {
		Optional<Employee> emp=employeeRepository.findById(id);
		return emp;
	}

	public Employee findEmployeeById(Integer id) {
		Employee emp=employeeRepository.findEmployeeById(id);
		return emp;
	}

//	public Employee getUserById(Integer id) {
//		// TODO Auto-generated method stub
//		return employeeRepository.findOne(id);
//	}
	
	
}
