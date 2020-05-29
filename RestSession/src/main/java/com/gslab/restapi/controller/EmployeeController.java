package com.gslab.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gslab.restapi.constant.Constant;
import com.gslab.restapi.entity.Employee;
import com.gslab.restapi.service.EmployeeService;

@RestController
@RequestMapping(value = "/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeServiceObj;

	@GetMapping(value = Constant.GET_LIST_OF_EMPLOYEES, headers = Constant.ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployees() {
		return employeeServiceObj.getAllEmployee();
	}

	@GetMapping(value = Constant.GET_EMPLOYEE_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(Constant.EMPLOYEE_ID) long id) {
		Employee employeeObj = employeeServiceObj.findById(id);
		if (employeeObj == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employeeObj, HttpStatus.OK);
	}

	@DeleteMapping(Constant.DELETE_EMPLOYEE_BY_ID)
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable long id, UriComponentsBuilder ucBuilder) {
		employeeServiceObj.deleteEmployeeById(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path(Constant.DELETE_EMPLOYEE_BY_ID).buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
	@PostMapping(value = Constant.ADD_EMPLOYEES, headers = Constant.ACCEPT_JSON)
	public ResponseEntity<Void> createEmployee(@RequestBody Employee employeeObj, UriComponentsBuilder ucBuilder) {
		employeeServiceObj.createEmployee(employeeObj);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path(Constant.GET_EMPLOYEE_BY_ID).buildAndExpand(employeeObj.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

}
