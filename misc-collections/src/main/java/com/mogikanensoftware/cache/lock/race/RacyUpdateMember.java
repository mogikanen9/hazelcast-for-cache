package com.mogikanensoftware.cache.lock.race;

import java.io.Serializable;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class RacyUpdateMember {

	public static void main(String[] args) throws Exception {
		HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();
		IMap<String, Value> map = hzInstance.getMap("map");
		String key = "1";
		map.put(key, new Value());
		System.out.println("Starting...");
		for (int k = 0; k < 1000; k++) {
			if (k % 100 == 0) {
				System.out.println("At: " + k);
			}
			Value value = map.get(key);
			Thread.sleep(10);
			value.field++;
			map.put(key, value);
		}
		System.out.println("Finished! Result = " + map.get(key).field);
	}

	static class Value implements Serializable {
		private static final long serialVersionUID = 1L;
		public int field;
	}

}
