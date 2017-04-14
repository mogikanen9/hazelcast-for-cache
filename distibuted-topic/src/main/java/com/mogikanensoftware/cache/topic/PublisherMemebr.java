package com.mogikanensoftware.cache.topic;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;

public class PublisherMemebr {

	public static void main(String[] args) {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		ITopic<String> sayHello = hz.getTopic("hello");
		sayHello.publish("Hello World!");
		System.out.println("Hello world was published!");
		
	}
}
