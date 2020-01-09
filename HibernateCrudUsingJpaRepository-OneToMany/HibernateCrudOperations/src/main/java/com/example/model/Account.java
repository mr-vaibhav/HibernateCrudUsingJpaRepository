package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accountdb")
public class Account {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer accountId;
	
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="accountnum")
	private Long accountNumber;
	
	
//	@OneToOne
//	private Employee employee;
	
//	@OneToOne(targetEntity=Employee.class,fetch=FetchType.EAGER , cascade=CascadeType.ALL)
//	@JoinColumn(name="employee_id",referencedColumnName="employeeId")
//	private Employee employee;
	
	@OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
	private Employee employee;
	
	public Account() {
		super();
	}
	
	
	
	

	public Account(Integer accountId, Long accountNumber, Employee employee) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.employee = employee;
	}





	public Account(Integer accountId, Long accountNumber) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
	}





	public Account(Long accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}


	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}





	public Integer getAccountId() {
		return accountId;
	}





	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}





	public Employee getEmployee() {
		return employee;
	}





	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	
}
