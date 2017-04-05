package com.mogikanensoftware.cache.service;

import java.util.Collection;
import java.util.Optional;

import com.mogikanensoftware.cache.bean.Event;

public interface EventService {

	Optional<Event> getById(String eventId);

	Collection<Event> getAll();
}
