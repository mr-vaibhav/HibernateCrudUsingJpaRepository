package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employeedb")
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer employeeId;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="salary")
	private Float salary;
	
	
	@Column(name="mobilenumber")
	private Long mobileNumber;
	
	@Column(name="emailid")
	private String emailId;
	
//	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
//	private Account account;
	
	
	@OneToOne(fetch=FetchType.EAGER , cascade=CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Account account;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "employee_benefits",
          joinColumns = { @JoinColumn(name = "employee_id") },
          inverseJoinColumns = { @JoinColumn(name = "benefits_id") })
	private List<Benefits> benefits;
	
	public Employee() {
		super();
	}	

	public Employee(Integer employeeId, String firstName, String lastName, Float salary, Long mobileNumber,
			String emailId, Account account, List<Benefits> benefits) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.account = account;
		this.benefits = benefits;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<Benefits> getBenefits() {
		return benefits;
	}

	public void setBenefits(List<Benefits> benefits) {
		this.benefits = benefits;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	

}
