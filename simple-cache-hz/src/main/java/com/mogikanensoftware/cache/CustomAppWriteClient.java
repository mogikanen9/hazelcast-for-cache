package com.mogikanensoftware.cache;

import java.util.Map;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

public class CustomAppWriteClient {

	public static void main(String[] args) {
		System.out.println("Getting our clients");

		ClientConfig config = new ClientConfig();
		HazelcastInstance client = HazelcastClient.newHazelcastClient(config);
		Map<String, String> customers = client.getMap("myCustomers");
		System.out.println(String.format("found #%d clients", customers.keySet().size()));
		customers.keySet().stream().forEach(customerId -> {
			customers.put(customerId, "N/A");
		});
		System.out.println("All customers were reset");

	}

}
