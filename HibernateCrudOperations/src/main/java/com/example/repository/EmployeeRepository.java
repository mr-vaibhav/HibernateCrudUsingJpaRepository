package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Benefits;
import com.example.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	@Query("SELECT u FROM Employee u WHERE u.employeeId = ?1")
	Employee findEmployeeById(Integer id);

//	@Query("select a,c from employeedb a join employee_account b on employeedb.employee_id = employee_account.employee_id join \r\n" + 
//			"accountdb c on accountdb.account_id = employee_account.account_id where employeedb.employee_id = ?1")
//	Employee findOne(Integer id);
	
	@Query("SELECT v FROM Employee u join u.benefits v  WHERE u.employeeId = ?1")
	List<Benefits> findBenefitsById(Integer id);
	

}
