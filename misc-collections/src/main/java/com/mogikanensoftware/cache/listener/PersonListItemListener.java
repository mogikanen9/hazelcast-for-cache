package com.mogikanensoftware.cache.listener;

import com.hazelcast.core.ItemEvent;
import com.hazelcast.core.ItemListener;

public class PersonListItemListener implements ItemListener<Person> {

	@Override
	public void itemAdded(ItemEvent<Person> item) {
		System.out.println(String.format("New person itme was added ->%s",item.toString()));

	}

	@Override
	public void itemRemoved(ItemEvent<Person> item) {
		System.out.println(String.format("Person itme was removed ->%s",item.toString()));

	}

}
