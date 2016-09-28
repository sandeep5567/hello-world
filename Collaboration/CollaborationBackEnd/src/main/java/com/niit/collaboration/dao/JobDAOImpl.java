package com.niit.collaboration.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.model.Job;

@Repository("jobDao")
public class JobDAOImpl implements JobDAO {

	@Autowired
	SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Job> list() {
		@SuppressWarnings("unchecked")
		List<Job> listJob = sessionFactory.getCurrentSession().createCriteria(Job.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listJob;
	}

	@Transactional
	public Job getJob(String jobId) {
		String hql="from Job where job_id='"+jobId+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Job> listJob=(List<Job>)query.list();
		
		if (listJob != null && !listJob.isEmpty()) {
			return listJob.get(0);
		}

		return null;
	}

	@Transactional
	public void saveorupdate(Job job) {
		sessionFactory.getCurrentSession().saveOrUpdate(job);
	}

	@Transactional
	public void delete(String jobId) {
		Job jobToDelete=new Job();
		jobToDelete.setJobId(jobId);
		sessionFactory.getCurrentSession().delete(jobToDelete);
	}

}
