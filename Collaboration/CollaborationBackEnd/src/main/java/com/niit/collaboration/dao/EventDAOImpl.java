package com.niit.collaboration.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.model.Event;

@Repository("eventDao")
public class EventDAOImpl implements EventDAO {

	@Autowired
	SessionFactory sessionFactory;

	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Event> list() {
		@SuppressWarnings("unchecked")
		List<Event> listEvent = sessionFactory.getCurrentSession().createCriteria(Event.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listEvent;
	}

	@Transactional
	public Event getEvent(String eventId) {
		String hql="from Event where event_id='"+eventId+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Event> listEvent=(List<Event>)query.list();
		
		if(listEvent!=null&&!listEvent.isEmpty())
		{
			listEvent.get(0);
		}
		
		return null;
	}

	@Transactional
	public void saveorupdate(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);
	}

	@Transactional
	public void delete(String eventId) {
		Event eventToDelete=new Event();
		eventToDelete.setEventId(eventId);
		sessionFactory.getCurrentSession().delete(eventToDelete);
	}

}
