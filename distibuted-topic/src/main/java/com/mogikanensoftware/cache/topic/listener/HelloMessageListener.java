package com.mogikanensoftware.cache.topic.listener;

import java.util.Date;

import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;

public class HelloMessageListener implements MessageListener<String> {

	@Override
	public void onMessage(Message<String> message) {
		System.out.println(String.format("Message '%s' was publsihed on '%s'", message.getMessageObject(),
				new Date(message.getPublishTime())));

	}

}
