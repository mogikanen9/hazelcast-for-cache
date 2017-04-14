package com.mogikanensoftware.cache.topic;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import com.mogikanensoftware.cache.topic.bean.Book;
import com.mogikanensoftware.cache.topic.listener.BookMessageListener;
import com.mogikanensoftware.cache.topic.listener.HelloMessageListener;

public class SubscriberMember {

	public static void main(String[] args) {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		ITopic<String> topic = hz.getTopic("hello");
		topic.addMessageListener(new HelloMessageListener());
		System.out.println("Subscribed");
		
		ITopic<Book> bookTopic = hz.getTopic("books");
		bookTopic.addMessageListener(new BookMessageListener());
		
		System.out.println("Subscribed to book...");
	}
}
