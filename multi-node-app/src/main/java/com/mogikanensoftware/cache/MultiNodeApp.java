package com.mogikanensoftware.cache;

import java.io.IOException;
import java.util.Map;
import java.util.Queue;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class MultiNodeApp {

	protected static HazelcastInstance createNode(String nodeName) {
		Config cfg = new Config(nodeName);
		HazelcastInstance node = Hazelcast.getOrCreateHazelcastInstance(cfg);
		return node;
	}

	public static void main( String[] args ) throws IOException
    {
    	HazelcastInstance nodeA = MultiNodeApp.createNode("My Node A");
    	Map<String,String> dogNameToOwner = nodeA.getMap("DogAndOwners");
    	dogNameToOwner.put("Polkan", "Vasya Pukin");
    	dogNameToOwner.put("Juchka", "Lena Nenasha");
    	dogNameToOwner.put("Svist", "Lesnik Zabolotnyi");
    	
    	HazelcastInstance nodeB = MultiNodeApp.createNode("My Node B");
    	Queue<String> partQ = nodeB.getQueue("Participants");
    	partQ.offer("Svist");
    	partQ.offer("Polkan");
    	partQ.offer("Juchka");
        
    	Queue<String> partQReplicated = nodeA.getQueue("Participants");
    	System.out.println("partQReplicated->");
    	partQReplicated.stream().forEach(System.out::println);
    	
    	
    	Map<String,String> dogNameToOwnerReplica = nodeA.getMap("DogAndOwners");
    	System.out.println("Printing owners for participating dogs...");
    	partQ.stream().forEach( dogName -> {System.out.println(
    				String.format("Participant->%s, owner->%s", dogName,dogNameToOwnerReplica.get(dogName)));});
    }
}
