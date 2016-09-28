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

import com.niit.collaboration.dao.JobDAO;
import com.niit.collaboration.model.Job;

@RestController
public class JobController {

	@Autowired
	JobDAO jobDAO;
	
	//--------------------------Retrieve All Jobs--------------------------------------------------------------------
	
	@RequestMapping(value="/job", method=RequestMethod.GET)
	public ResponseEntity<List<Job>> listAllJobs()
	{
		List<Job> users = jobDAO.list();
		if(users.isEmpty())
		{
			return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Job>>(users,HttpStatus.OK);
	}
	
	//--------------------------Retrieve Single Job-------------------------------------------------------------------
	
		@RequestMapping(value="/job/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Job> getJob(@PathVariable("id") String id)
		{
			Job job=jobDAO.getJob(id);
			if(job==null)
			{
				return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Job>(job, HttpStatus.OK);
		}
		
	//--------------------------Post a new Job------------------------------------------------------------------------
		
		@RequestMapping(value="/job", method=RequestMethod.POST)
		public ResponseEntity<Void> createJob(@RequestBody Job job, UriComponentsBuilder ucBuilder)
		{
			jobDAO.saveorupdate(job);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/job/{id}").buildAndExpand(job.getJobId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		
	//--------------------------Update a new Job------------------------------------------------------------------------
		
		@RequestMapping(value="/job/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Job> getJob(@PathVariable("id") String id, @RequestBody Job job)
		{
			Job currentJob=jobDAO.getJob(id);
			if(currentJob==null)
			{
				return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
			}
			
			currentJob.setDescription(currentJob.getDescription());
			currentJob.setQualification(currentJob.getQualification());
			currentJob.setExperience(currentJob.getExperience());
			currentJob.setVacancies(currentJob.getVacancies());
			
			jobDAO.saveorupdate(currentJob);
			return new ResponseEntity<Job>(currentJob, HttpStatus.OK);
		}
		
	//-----------------------------Delete a Job---------------------------------------------------------------------------
		
		@RequestMapping(value = "/job/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Job> deleteJob(@PathVariable("id") String id)
		{
			jobDAO.delete(id);
			return new ResponseEntity<Job>(HttpStatus.NO_CONTENT);
		}
	
}
