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

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

@RestController
public class BlogController {

	@Autowired
	BlogDAO blogDAO;
	
	//--------------------------Retrieve All Blogs--------------------------------------------------------------------
	
		@RequestMapping(value="/blog", method=RequestMethod.GET)
		public ResponseEntity<List<Blog>> listAllBlogs()
		{
			List<Blog> blog = blogDAO.list();
			if(blog.isEmpty())
			{
				return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Blog>>(blog,HttpStatus.OK);
		}
		
	//--------------------------Retrieve Single Blog-------------------------------------------------------------------
		
		@RequestMapping(value="/blog/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Blog> getBlog(@PathVariable("id") String id)
		{
			Blog blog=blogDAO.getBlog(id);
			if(blog==null)
			{
				return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		}
		
	//--------------------------Create a new Blog------------------------------------------------------------------------
		
		@RequestMapping(value="/blog", method=RequestMethod.POST)
		public ResponseEntity<Void> createUser(@RequestBody Blog blog, UriComponentsBuilder ucBuilder)
		{
			blogDAO.saveorupdate(blog);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/blog/{id}").buildAndExpand(blog.getBlogId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		
	//-----------------------------Delete a Blog---------------------------------------------------------------------------
		
		@RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Blog> deleteUser(@PathVariable("id") String id)
		{
			blogDAO.delete(id);
			return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
		}
	
}
