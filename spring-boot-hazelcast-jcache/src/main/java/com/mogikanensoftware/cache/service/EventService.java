package com.mogikanensoftware.cache.service;

import java.util.Collection;

import javax.cache.annotation.CacheResult;

import com.mogikanensoftware.cache.bean.Event;

public interface EventService {

	@CacheResult(cacheName="events")
	Event getById(String eventId);

	@CacheResult(cacheName="allEvents")
	Collection<Event> getAll();
}
