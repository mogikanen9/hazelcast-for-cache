package com.mogikanensoftware.cache.web;

import java.util.Collection;
import java.util.Optional;

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

	@RequestMapping(method = RequestMethod.GET, path = "/")
	public Collection<Event> listAll() {
		return eventService.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{eventId}")
	public Event findById(@PathVariable String eventId) {
		Optional<Event> result = eventService.getById(eventId);
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}
}
