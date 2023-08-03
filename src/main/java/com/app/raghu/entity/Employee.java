package com.app.raghu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emptab")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	
	public Employee() {
		super();
		
	}
	
	public Employee(Integer id, String name, String department, String account, String currency, String joiningDate,
			String exitDate) {
		super();
		this.id = id;
		Name = name;
		this.department = department;
		this.account = account;
		this.currency = currency;
		this.joiningDate = joiningDate;
		this.exitDate = exitDate;
	}

	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String Name;
	private String department;
	private String  account;
	private String  currency;
	@JsonFormat(pattern="MM-DD-YYYY",shape= Shape.STRING)
	@Column(name="joining Date")
	private String  joiningDate;
	@JsonFormat(pattern="MM-DD-YYYY",shape= Shape.STRING)
	@Column(name="exit Date")
	private String  exitDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getExitDate() {
		return exitDate;
	}
	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", Name=" + Name + ", department=" + department + ", account=" + account
				+ ", currency=" + currency + ", joiningDate=" + joiningDate + ", exitDate=" + exitDate + "]";
	}
	
}
