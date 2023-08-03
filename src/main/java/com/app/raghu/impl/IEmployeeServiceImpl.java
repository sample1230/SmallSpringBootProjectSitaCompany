package com.app.raghu.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.raghu.entity.Employee;
import com.app.raghu.exception.EmployeeNotFoundException;
import com.app.raghu.repo.EmployeeRepository;
import com.app.raghu.service.IEmployeeService;
@Service
public class IEmployeeServiceImpl implements IEmployeeService {
	@Autowired
  private EmployeeRepository repo;
	
	public Integer saveEmployee(Employee employee) {
    Integer id = repo.save(employee ).getId();
		return id;
	}

	
	public List<Employee> getAllEmployees() {
		List<Employee>list = repo.findAll();
		return list;
	}

	
	public Employee getOneEmployee(Integer id) {
		 return repo.findById(id).
		orElseThrow(
				()->new EmployeeNotFoundException("Employee'"+id+"'not exist")
				);
		
	}

	
	public void updateEmployee(Employee employee) {
		if(employee.getId()==null||!repo.existsById(employee.getId()))
			throw(new EmployeeNotFoundException("Employee'"+employee.getId()+"'not exist"));
		else
			repo.save(employee);
	}

}
