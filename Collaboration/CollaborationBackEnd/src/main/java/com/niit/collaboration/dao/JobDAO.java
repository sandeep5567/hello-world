package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Job;

public interface JobDAO {

	public List<Job> list();
	
	public Job getJob(String jobId);
	
	public void saveorupdate(Job job);
	
	public void delete(String jobId);
	
}
