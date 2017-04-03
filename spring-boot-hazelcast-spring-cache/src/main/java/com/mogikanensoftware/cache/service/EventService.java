package com.mogikanensoftware.cache.service;

import java.util.Map;

import com.mogikanensoftware.cache.bean.Event;

public interface EventService {

	Event getById(String eventId);

	Map<String, Event> getAll();
}
