package com.mogikanensoftware.cache.topic;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import com.mogikanensoftware.cache.topic.bean.Book;

public class BookPublisherMember {

	public static void main(String[] args) throws InterruptedException {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		ITopic<Book> sayHello = hz.getTopic("books");
		sayHello.publish(new Book("Java 8 in Action","N/A"));
		System.out.println("java 8 publsihed...");
		Thread.sleep(3000);
		sayHello.publish(new Book("Mastering Hazelcast","Greg Luck"));
		System.out.println("hazelcast publsihed...");
		
		hz.shutdown();
	}
}
