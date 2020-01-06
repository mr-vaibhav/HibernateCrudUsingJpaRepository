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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employeedb")
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
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
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "employee_account",
            joinColumns = { @JoinColumn(name = "employee_id", referencedColumnName = "employeeId") },
            inverseJoinColumns = { @JoinColumn(name = "account_id", referencedColumnName = "accountId") })
	private Account accounts;

	@OneToMany(targetEntity = Benefits.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_employeeid" , referencedColumnName = "employeeId")
	private List<Benefits> benefits;
	
	public Employee() {
		super();
	}
	
	public Employee(Integer employeeId, @NotNull @Size(max = 100) String firstName, @Size(max = 100) String lastName,
			@NotNull Float salary, @NotNull @Size(max = 10) Long mobileNumber, String emailId, Account accounts) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.accounts = accounts;
	}
	
	

	public Employee(Integer employeeId, String firstName, String lastName, Float salary, Long mobileNumber,
			String emailId, Account accounts, List<Benefits> benefits) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.accounts = accounts;
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

	public Account getAccounts() {
		return accounts;
	}

	public void setAccounts(Account accounts) {
		this.accounts = accounts;
	}

	public List<Benefits> getBenefits() {
		return benefits;
	}

	public void setBenefits(List<Benefits> benefits) {
		this.benefits = benefits;
	}
	
	
	
	
	
	
	

}
