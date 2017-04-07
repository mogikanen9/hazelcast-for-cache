package com.mogikanensoftware.cache.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.mogikanensoftware.cache.bean.Event;
import com.mogikanensoftware.cache.service.EventService;

@Component
public class EventServiceImpl implements EventService {

	@Override
	public Event getById(final String eventId) {
		Predicate<Event> eventComparePredicate = e -> e.getEventId().equalsIgnoreCase(eventId);
		return this.getAll().stream().filter(eventComparePredicate).findFirst().get();
	}

	@Override
	public Collection<Event> getAll() {
		// simulate load
		try {
			System.out.println("loading data...");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Arrays.asList(new Event("CarnavalRio2017", "Carnaval in Rio 2017!"),
				new Event("WorldCup2018", "Soccer World Cup in Russia 2018!"),
				new Event("TorontoPraid2017", "Praid Parade in Toronto 2017!"));

	}

}
