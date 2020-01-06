package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accountdb")
public class Account {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer accountId;
	
	@Column(name="accountnum")
	private Long accountNumber;
	
	
	
	
	public Account() {
		super();
	}
	
	
	
	public Account(Integer accountId, Long accountNumber) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
	}



	public Integer getAccountId() {
		return accountId;
	}
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	} 
	
	
	
	
}
