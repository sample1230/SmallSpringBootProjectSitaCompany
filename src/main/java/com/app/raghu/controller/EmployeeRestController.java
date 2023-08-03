package com.app.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.raghu.entity.Employee;
import com.app.raghu.exception.EmployeeNotFoundException;
import com.app.raghu.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService service;
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(
			@RequestBody Employee employee)
		{
		Integer id=service.saveEmployee(employee);
		return new ResponseEntity<String>("Employee'"+id+"'Created",HttpStatus.OK);
		
		}
		@GetMapping("/all")
		public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> list   =	service.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
			}
		@GetMapping("/find/{id}")
		public ResponseEntity<?> fetchOneEmployee(
				@PathVariable Integer id)
		{ 
			ResponseEntity<?> response = null;
		
			try {
		Employee employee = service.getOneEmployee(id);
				response = new ResponseEntity<Employee>
				(employee,HttpStatus.OK);
			}
			catch(EmployeeNotFoundException eefe) {
				eefe.printStackTrace();
				response = new ResponseEntity<String>
				(eefe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return response ;
		}
			@PutMapping("/modify")
			public ResponseEntity<String> updateEmployee(
					@RequestBody Employee employee
					)
			{ 
				ResponseEntity<String> response = null;
			
				try {
			 service.updateEmployee(employee);
					response = new ResponseEntity<String>
					("Employee'"+employee.getId()+"'Update",
							HttpStatus.OK);
				}catch(EmployeeNotFoundException eefe) {
					eefe.printStackTrace();
					response = new ResponseEntity<String>
					(eefe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
				}
				return response;
		}
		
		
			
			
		
			
		
		}
	


