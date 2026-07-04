package com.shinra.xeno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinra.xeno.model.User;
import com.shinra.xeno.service.UserService;

/**
 * @author Damian Zylski
 * @since 6/09/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary User Controller - Handles all requests and responses related to User endpoints.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/Users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController
{
	
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService)
	{
		this.userService = userService;
	}
	
	/**
     * @summary Test
     *
     * @return HTTP response 200 on success with any data if available, HTTP 404 error if not found
     * @url /
     */
	@GetMapping("/GetUser")
	public ResponseEntity<User> test()
	{
		
		try
		{
			User user = new User();
			user.setEmail("test@hotmail.com");
			user.setUsername("tester");
			
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} 
		catch (Exception e)
		{
			//TODO: Implement some real logging
			e.printStackTrace();
			return new ResponseEntity<User>( HttpStatus.NOT_FOUND);
		}
	}
	
	
}
