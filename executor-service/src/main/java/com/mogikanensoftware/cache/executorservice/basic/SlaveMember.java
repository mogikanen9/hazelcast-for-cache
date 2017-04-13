package com.mogikanensoftware.cache.executorservice.basic;

import com.hazelcast.core.Hazelcast;

public class SlaveMember {
	public static void main(String[] args) {
		Hazelcast.newHazelcastInstance();
	}
}
