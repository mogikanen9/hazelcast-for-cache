package com.mogikanensoftware.cache.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mogikanensoftware.cache.bean.Employee;
import com.mogikanensoftware.cache.service.EmployeeService;

@RestController
public class EmployeeRestService {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestService( EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/v1/employees/list")
	public List<Employee> listAll(){
		return employeeService.listAll();
	}
	
}
