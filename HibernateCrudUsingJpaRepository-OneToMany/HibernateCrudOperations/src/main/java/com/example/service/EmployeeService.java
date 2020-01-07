package com.example.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.controller.EmployeeController;
import com.example.model.Benefits;
import com.example.model.Employee;
import com.example.repository.AccountRepository;
import com.example.repository.BenefitsRepository;
import com.example.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	BenefitsRepository benefitsRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	@Transactional
	public void createEmployee(Employee employee) {
	logger.info("Inside Create Employee-------->");
	
	try {
	List<Benefits> mybenefits = employee.getBenefits();
	
	//List<Benefits> benefits = null;
	List<Benefits> listBenefits = null;
	
	for(Benefits benefit : mybenefits) {
		listBenefits = benefitsRepository.findBenefitsById(benefit.getId());
	}
	
	
	
		//Benefits benefits = benefitsRepository.findByBeneficiaryName(employee.getBenefits().get(index));
		employee.setBenefits(listBenefits);
		employeeRepository.save(employee);
	}catch(Exception e) {
		e.printStackTrace();
	}
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
