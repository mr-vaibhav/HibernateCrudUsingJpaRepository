package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Benefits;
import com.example.repository.BenefitsRepository;
import com.example.repository.EmployeeRepository;

@Service
public class BenefitsService {
	
	@Autowired
	BenefitsRepository benefitsRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Benefits> findBenefitsById(Integer id) {
		List<Benefits> benefits=employeeRepository.findBenefitsById(id);
		return benefits;
	}

}
