package com.shinra.xeno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shinra.xeno.model.SiteContent;
import com.shinra.xeno.model.User;
import com.shinra.xeno.service.SiteContentService;

/**
 * @author Damian Zylski
 * @since 6/29/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Site Content Controller - Handles all requests and responses related to Site Content endpoints.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/SiteContent", produces = MediaType.APPLICATION_JSON_VALUE)
public class SiteContentController
{
	@Autowired
	private SiteContentService siteContentService;
	
	public SiteContentController(SiteContentService siteContentService)
	{
		this.siteContentService = siteContentService;
	}
	
	/**
     * @summary Get Site Content by id
     *
     * @param id id of the content item to get
     * @return HTTP response 200 on success with any data if available, HTTP 404 error if not found
     * @url /
     */
	@GetMapping("/GetSiteContent/{id}")
	@PreAuthorize("permitAll()")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<SiteContent> getSiteContentById(@PathVariable Long id, @RequestParam Long userId)
	{
		
		try
		{
			System.out.println("UserID: "+userId);
			SiteContent siteContent = siteContentService.findById(id);
			
			return new ResponseEntity<SiteContent>(siteContent, HttpStatus.OK);
		} 
		catch (Exception e)
		{
			//TODO: Implement some real logging
			e.printStackTrace();
			return new ResponseEntity<SiteContent>( HttpStatus.NOT_FOUND);
		}
	}

}
