package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Event;

public interface EventDAO {

	public List<Event> list();
	
	public Event getEvent(String eventId);
	
	public void saveorupdate(Event event);
	
	public void delete(String eventId);
	
}
