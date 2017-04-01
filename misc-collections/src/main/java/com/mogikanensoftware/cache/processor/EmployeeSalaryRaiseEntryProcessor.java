package com.mogikanensoftware.cache.processor;

import java.util.Map.Entry;

import com.hazelcast.map.AbstractEntryProcessor;

public class EmployeeSalaryRaiseEntryProcessor extends AbstractEntryProcessor<String, Employee> {
	private static final long serialVersionUID = 1L;

	private int increaseValue;

	public EmployeeSalaryRaiseEntryProcessor(int increaseValue) {
		super();
		this.increaseValue = increaseValue;
	}

	@Override
	public Object process(Entry<String, Employee> entry) {
		Employee employee = entry.getValue();
		employee.setSalary(employee.getSalary() + increaseValue);
		entry.setValue(employee);
		return null;
	}

}
