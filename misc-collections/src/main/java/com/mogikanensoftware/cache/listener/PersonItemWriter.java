package com.mogikanensoftware.cache.listener;

import java.util.Queue;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class PersonItemWriter {

	public static void main(String[] args) {
		Config cfg = new Config();
		HazelcastInstance node = Hazelcast.newHazelcastInstance(cfg);
		Queue<Person> personQueue = node.getQueue("People");

		personQueue.add(new Person("Ivan", "Gorohov", 22));
		personQueue.add(new Person("Lena", "Zuzina", 30));
		personQueue.add(new Person("Linda", "Vorona", 29));

		System.out.println(String.format("# of people->%d", personQueue.size()));

		personQueue.remove(new Person("Lena", "Zuzina", 30));

		System.out.println(String.format("# of people after Lena was removed->%d", personQueue.size()));

	}

}
