package com.mogikanensoftware.cache.interceptor;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class MyEventInterceptorSample {

	public static void main(String[] args) {

		HazelcastInstance instance = Hazelcast.newHazelcastInstance();
		IMap<String, MyEvent> events = instance.getMap("myEvents");
		events.addInterceptor(new EventMapInterceptior());
		
		// fill the map
		for (int i = 0; i < 10; i++) {
			events.put("ev#" + i, new MyEvent("My Evenet #" + i));
		}

		// reading
		events.keySet().forEach(key -> {
			System.out.println(String.format("key=%s,event=%s", key, events.get(key).toString()));
		});
		
		instance.shutdown();
	}

}
