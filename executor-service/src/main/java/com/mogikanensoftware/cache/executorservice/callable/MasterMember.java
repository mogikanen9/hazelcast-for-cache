package com.mogikanensoftware.cache.executorservice.callable;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IExecutorService;

public class MasterMember {
	public static void main(String[] args) throws Exception {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		IExecutorService executor = hz.getExecutorService("exec");
		
		int n = 5;
		Future<Long> future = executor.submit(new FibonacciCallable(n));
		try {
			long result = future.get(10, TimeUnit.SECONDS);
			System.out.println("Result: " + result);
		} catch (TimeoutException ex) {
			System.out.println("A timeout happened");
		}
		
		hz.shutdown();
	}
}
