package com.mogikanensoftware.cache.listener;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ICollection;

public class PersonItemListenerSample {

	public static void main(String[] args) {

		Config cfg = new Config();
		HazelcastInstance node = Hazelcast.newHazelcastInstance(cfg);
		ICollection<Person> personQueue = node.getQueue("People");
		personQueue.addItemListener(new PersonListItemListener(), true);
		System.out.println("Listener was added...");

		personQueue.add(new Person("Ivan", "Gorohov", 22));
		personQueue.add(new Person("Lena", "Zuzina", 30));
		personQueue.add(new Person("Linda", "Vorona", 29));
		
		System.out.println(String.format("# of people->%d", personQueue.size()));
		
		personQueue.remove(new Person("Lena", "Zuzina", 30));
		
		System.out.println(String.format("# of people after Lena was removed->%d", personQueue.size()));
		
		node.shutdown();
	}

}
