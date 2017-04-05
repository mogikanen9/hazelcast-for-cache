package com.mogikanensoftware.cache.service;

import java.util.Map;

import org.springframework.cache.annotation.Cacheable;

import com.mogikanensoftware.cache.bean.Event;

public interface EventService {

	@Cacheable("events")
	Event getById(String eventId);

	@Cacheable("allEvents")
	Map<String, Event> getAll();
}
