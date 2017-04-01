package com.mogikanensoftware.cache.lock.pessimistic;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class PessimisticUpdateMember {

	public static void main(String[] args) throws InterruptedException {
		Config cfg = new Config();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
		IMap<String, Member> memberMap = instance.getMap("members");

		String key = "member1";
		memberMap.put(key, new Member(0));

		for (int i = 0; i < 1000; i++) {
			memberMap.lock(key);
			try {
				Member member = memberMap.get(key);
				Thread.sleep(100);
				member.setField(member.getField() + 1);
				memberMap.put(key, member);
				if(i%100==0){
					System.out.println(String.format("member.getField()->%d", member.getField()));
				}
			} finally {
				memberMap.unlock(key);
			}
		}
		System.out.println("Finished! Result = " + memberMap.get(key).getField());
	}

}
