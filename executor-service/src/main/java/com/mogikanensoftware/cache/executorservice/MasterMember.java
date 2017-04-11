package com.mogikanensoftware.cache.executorservice;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IExecutorService;
import com.mogikanensoftware.cache.executorservice.task.EchoTask;

/**
 * Hello world!
 *
 */
public class MasterMember {
	public static void main(String[] args) throws Exception {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		IExecutorService executor = hz.getExecutorService("exec");
		for (int k = 1; k <= 1000; k++) {
			Thread.sleep(1000);
			System.out.println("Producing echo task: " + k);
			executor.execute(new EchoTask("" + k));
		}
		System.out.println("EchoTaskMain finished!");
	}
}
