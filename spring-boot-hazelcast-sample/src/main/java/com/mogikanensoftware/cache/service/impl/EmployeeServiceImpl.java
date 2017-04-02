package com.mogikanensoftware.cache.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mogikanensoftware.cache.bean.Employee;
import com.mogikanensoftware.cache.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<Employee> listAll() {
		List<Employee> result = new ArrayList<>();
		for(int i=0;i<10;i++){
			result.add(new Employee("Jenny "+i,"Doe"+i,1500+i));
		}
		return result;
	}

}
