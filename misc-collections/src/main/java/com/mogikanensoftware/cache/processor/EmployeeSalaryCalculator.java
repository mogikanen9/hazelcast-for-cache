package com.mogikanensoftware.cache.processor;

import java.util.Map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class EmployeeSalaryCalculator {

	public static void main(String[] args) {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		IMap<String, Employee> employees = hz.getMap("employees");
		employees.put("John Doe", new Employee("John Doe", 1300));
		employees.put("Mark Spencer", new Employee("Mark Spencer", 1200));
		employees.put("Linda Spencer", new Employee("Linda Spencer", 1400));
		Map<String, Object> results = employees.executeOnEntries(new EmployeeSalaryRaiseAndReturnEntryProcessor(50));
		int summOfAllSalaries = results.values().stream().mapToInt(val -> ((Integer)val).intValue()).sum();
		System.out.println(String.format("Total amount of alll employee' salaries after raise -> %d", summOfAllSalaries));
		System.exit(0);
	}

}
