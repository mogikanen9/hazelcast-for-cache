package com.mogikanensoftware.cache.processor;

import java.util.Map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class EmployeeRaiseProcessor {
	public static void main(String[] args) {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		IMap<String, Employee> employees = hz.getMap("employees");
		employees.put("John Doe", new Employee("John Doe", 1300));
		employees.put("Mark Spencer", new Employee("Mark Spencer", 1200));
		employees.put("Linda Spencer", new Employee("Linda Spencer", 1400));
		employees.executeOnEntries(new EmployeeSalaryRaiseEntryProcessor(50));
		for (Map.Entry<String, Employee> entry : employees.entrySet()) {
			System.out.println(entry.getKey() + " salary: " + entry.getValue().getSalary());
		}
		System.exit(0);
	}
}
