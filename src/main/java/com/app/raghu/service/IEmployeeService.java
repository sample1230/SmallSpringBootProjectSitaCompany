package com.app.raghu.service;

import java.util.List;

import com.app.raghu.entity.Employee;

public interface IEmployeeService {
	Integer saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getOneEmployee(Integer id);
	 void  updateEmployee(Employee employee);

}
