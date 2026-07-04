package com.shinra.xeno.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Damian Zylski
 * @since 6/09/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Homepage Controller - Handles requests for the homepage
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomepageController
{

	public HomepageController()
	{
		
	}
	
	/**
     * @summary Returns the homepage for the Xenoboard app
     *
     * @return HTTP response 200 on success with any data if available, HTTP 404 error if not found
     * @url /
     */
	@GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> loadHomepage()
	{
		
		try
		{
			String message = "Welcome to Xenoboard!";
			
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} 
		catch (Exception e)
		{
			//TODO: Implement some real logging
			e.printStackTrace();
			return new ResponseEntity<String>("Error loading homepage", HttpStatus.NOT_FOUND);
		}
	}
}
