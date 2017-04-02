package com.mogikanensoftware.cache.lock.pessimistic;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class OptimisticUpdateMember {

	public static void main(String[] args) throws Exception {
		HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();
		IMap<String, Member> map = hzInstance.getMap("members");
		String key = "memA";
		map.put(key, new Member(0));
		System.out.println("Starting");
		for (int k = 0; k < 1000; k++) {
			if (k % 10 == 0)
				System.out.println("At: " + k);
			while (true) {
				Member oldValue = map.get(key);
				Member newValue = new Member(oldValue.getField());
				// Thread.sleep(10);
				newValue.setField(oldValue.getField() + 1);

				// use replace for optimistic lock
				if (map.replace(key, oldValue, newValue)) {
					break;
				}
			}
		}
		System.out.println("Finished! Result = " + map.get(key).getField());
	}

}
