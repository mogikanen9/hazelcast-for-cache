package com.mogikanensoftware.cache.topic.listener;

import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;
import com.mogikanensoftware.cache.topic.bean.Book;

public class BookMessageListener implements MessageListener<Book> {

	@Override
	public void onMessage(Message<Book> message) {
		System.out.println(String.format("new book arriverd->%s", message.getMessageObject()));

	}

}
