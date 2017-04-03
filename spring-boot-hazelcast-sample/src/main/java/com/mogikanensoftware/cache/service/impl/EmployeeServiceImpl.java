package com.mogikanensoftware.cache.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.core.HazelcastInstance;
import com.mogikanensoftware.cache.bean.Employee;
import com.mogikanensoftware.cache.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	private HazelcastInstance hazelcastInstance;
	
	@Autowired
	public EmployeeServiceImpl(HazelcastInstance hazelcastInstance) {
		super();
		this.hazelcastInstance = hazelcastInstance;
	}

	@Override
	public List<Employee> listAll() {
		
		List<Employee> employees = this.hazelcastInstance.getList("emloyees");
		if(employees.isEmpty()){
			System.out.println("Creating empoyees...");
			for(int i=0;i<10;i++){
				employees.add(new Employee("Jenny "+i,"Doe"+i,1500+i));
			}
		}else{
			System.out.println("Getting employees from cache");
		}
		
		return employees;
	}

}
