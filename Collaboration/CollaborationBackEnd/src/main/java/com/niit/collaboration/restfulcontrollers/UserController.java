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

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.Users;

@RestController
public class UserController {

	@Autowired
	UserDAO userDAO;

	//--------------------------Retrieve All Users--------------------------------------------------------------------
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ResponseEntity<List<Users>> listAllUsers()
	{
		List<Users> users = userDAO.list();
		if(users.isEmpty())
		{
			return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Users>>(users,HttpStatus.OK);
	}
	
	//--------------------------Retrieve Single User-------------------------------------------------------------------
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> getUser(@PathVariable("id") String id)
	{
		Users users=userDAO.get(id);
		if(users==null)
		{
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}
	
	//--------------------------Create a new User------------------------------------------------------------------------
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody Users users, UriComponentsBuilder ucBuilder)
	{
		userDAO.saveorupdate(users);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(users.getUserId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//--------------------------Update a new User------------------------------------------------------------------------
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Users> getUser(@PathVariable("id") String id, @RequestBody Users users)
	{
		Users currentUser=userDAO.get(id);
		if(currentUser==null)
		{
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
		
		currentUser.setUserName(users.getUserName());
		currentUser.setEmail(users.getEmail());
		currentUser.setPassword(users.getPassword());
		
		userDAO.saveorupdate(currentUser);
		return new ResponseEntity<Users>(currentUser, HttpStatus.OK);
	}
	
	//-----------------------------Delete a User---------------------------------------------------------------------------
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Users> deleteUser(@PathVariable("id") String id)
	{
		userDAO.delete(id);
		return new ResponseEntity<Users>(HttpStatus.NO_CONTENT);
	}
	
}
