package com.mogikanensoftware.cache.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mogikanensoftware.cache.bean.Event;
import com.mogikanensoftware.cache.service.EventService;

@RestController
@RequestMapping("/v1/events")
public class EventRestController {

	private EventService eventService;

	@Autowired
	public EventRestController(EventService eventService) {
		super();
		this.eventService = eventService;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/all")
	public Collection<Event> listAll() {
		return eventService.getAll().values();
	}

	@RequestMapping(method=RequestMethod.GET,path="/{eventId}")
	public Event findById(@PathVariable String eventId){
		return eventService.getById(eventId);
	}
}
