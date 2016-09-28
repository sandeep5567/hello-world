package com.niit.collaboration.restfulcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaboration.dao.EventDAO;
import com.niit.collaboration.model.Event;

@RestController
public class EventController {

	@Autowired
	EventDAO eventDAO;
	
	//--------------------------Retrieve All Events--------------------------------------------------------------------
	
		@RequestMapping(value="/event", method=RequestMethod.GET)
		public ResponseEntity<List<Event>> listAllEvents()
		{
			List<Event> event = eventDAO.list();
			if(event.isEmpty())
			{
				return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Event>>(event,HttpStatus.OK);
		}
		
	//--------------------------Retrieve Single Event-------------------------------------------------------------------
		
		@RequestMapping(value="/event/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Event> getEvent(@PathVariable("id") String id)
		{
			Event event=eventDAO.getEvent(id);
			if(event==null)
			{
				return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Event>(event, HttpStatus.OK);
		}
		
	//--------------------------Create a new Event------------------------------------------------------------------------
		
		@RequestMapping(value="/event", method=RequestMethod.POST)
		public ResponseEntity<Void> createEvent(@RequestBody Event event, UriComponentsBuilder ucBuilder)
		{
			eventDAO.saveorupdate(event);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/event/{id}").buildAndExpand(event.getEventId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		
	//--------------------------Update an Event------------------------------------------------------------------------
		
		@RequestMapping(value="/event/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Event> getEvent(@PathVariable("id") String id, @RequestBody Event event)
		{
			Event currentEvent=eventDAO.getEvent(id);
			if(currentEvent==null)
			{
				return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
			}
			
			currentEvent.setEventDate(event.getEventDate());
			currentEvent.setVenue(event.getVenue());
			currentEvent.setCity(event.getCity());
			currentEvent.setState(event.getState());
			currentEvent.setCountry(event.getCountry());
			currentEvent.setPin(event.getPin());
			
			eventDAO.saveorupdate(currentEvent);
			return new ResponseEntity<Event>(currentEvent, HttpStatus.OK);
		}
		
	//-----------------------------Delete an Event---------------------------------------------------------------------------
		
		@RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Event> deleteEvent(@PathVariable("id") String id)
		{
			eventDAO.delete(id);
			return new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
		}
	
}
