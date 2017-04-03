package com.mogikanensoftware.cache.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mogikanensoftware.cache.bean.Event;
import com.mogikanensoftware.cache.service.EventService;

@Component
public class EventServiceImpl implements EventService {

	@Override
	public Event getById(String eventId) {
		return this.getAll().get(eventId);
	}

	@Override
	public Map<String, Event> getAll() {
		// simulate load
		try {
			System.out.println("loading data");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Event> events = new HashMap<>();
		events.put("CarnavalRio2017", new Event("CarnavalRio2017", "Carnaval in Rio 2017!"));
		events.put("WorldCup2018", new Event("WorldCup2018", "Soccer World Cup in Russia 2018!"));
		events.put("TorontoPraid2017", new Event("TorontoPraid2017", "Praid Parade in Toronto 2017!"));
		return events;
	}

}
