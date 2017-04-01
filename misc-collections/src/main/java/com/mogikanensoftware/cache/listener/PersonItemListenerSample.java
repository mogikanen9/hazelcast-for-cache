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
	}

}
