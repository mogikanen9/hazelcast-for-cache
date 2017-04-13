package com.mogikanensoftware.cache.executorservice.callable;

import com.hazelcast.core.ExecutionCallback;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IExecutorService;

public class MasterMemberWithCallback {
	public static void main(String[] args) {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		IExecutorService executor = hz.getExecutorService("exec");
		ExecutionCallback<Long> callback = new ExecutionCallback<Long>() {
			public void onFailure(Throwable t) {
				t.printStackTrace();
			}

			public void onResponse(Long response) {
				System.out.println("Result: " + response);
			}
		};
		executor.submit(new FibonacciCallable(10), callback);
		System.out.println("Fibonacci task submitted");
		
		hz.shutdown();
	}
}
