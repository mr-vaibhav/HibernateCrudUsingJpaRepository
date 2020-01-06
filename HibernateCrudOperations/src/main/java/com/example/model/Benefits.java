package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "benefitsdb")
public class Benefits {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	@Column(name="salary")
	private Float salary;
	
	@Column(name = "holiday")
	private String holiday;
	
	@Column(name = "bonus")
	private Float bonus;
	
	public Benefits() {
		super();
	}

	public Benefits(Integer id, Float salary, String holiday, Float bonus) {
		super();
		this.id = id;
		this.salary = salary;
		this.holiday = holiday;
		this.bonus = bonus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	public Float getBonus() {
		return bonus;
	}

	public void setBonus(Float bonus) {
		this.bonus = bonus;
	}

	
}
