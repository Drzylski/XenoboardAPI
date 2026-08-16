package com.shinra.xeno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shinra.xeno.dto.FileUploadListDto;
import com.shinra.xeno.dto.NewTopicDto;
import com.shinra.xeno.dto.TopicLikeDTO;
import com.shinra.xeno.model.SiteContent;
import com.shinra.xeno.model.Topic;
import com.shinra.xeno.service.TopicService;

/**
 * @author Damian Zylski
 * @since 7/31/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Topic Controller - Handles all requests and responses related to Topic endpoints.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/Topics", produces = MediaType.APPLICATION_JSON_VALUE)
public class TopicController
{
	@Autowired
	private TopicService topicService;
	
	public TopicController(TopicService topicService)
	{
		this.topicService = topicService;
	}
	
	/**
     * @summary Update topic Likes by id
     *
     * @param id id of the topic item to get
     * @param num number of likes
     * @return HTTP response 200 on success with any data if available, HTTP 400 error if performed
     * @url /UpdateTopicLikes/{id}
     */
	@PutMapping("/UpdateTopicLikes/{id}")
	public ResponseEntity<Topic> updateTopicLikesById(@PathVariable Long id, @RequestBody TopicLikeDTO topicLikeDTO)
	{
		
		try
		{
			System.out.println("UserID: "+topicLikeDTO.getUserId());
			Topic topic = topicService.updateLikes(topicLikeDTO);
			
			return new ResponseEntity<Topic>(topic, HttpStatus.OK);
		} 
		catch (Exception e)
		{
			//TODO: Implement some real logging
			e.printStackTrace();
			return new ResponseEntity<Topic>( HttpStatus.NOT_FOUND);
		}
	}
	
	/**
     * @summary Update topic by id
     *
     * @param id id of the topic item to get
     * @return HTTP response 200 on success with any data if available, HTTP 400 error if performed
     * @url /UpdateTopic/{id}
     */
	@PutMapping(value="/UpdateTopic/{id}")
	@PreAuthorize("permitAll()")
	public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody NewTopicDto newTopicDto)
	{
		
		try
		{
			System.out.println(newTopicDto);
			System.out.println("UserID: "+newTopicDto.getUuid());
			Topic topic = topicService.updateTopic(newTopicDto);
			//Topic topic = null;
			
			return new ResponseEntity<Topic>(topic, HttpStatus.OK);
		} 
		catch (Exception e)
		{
			//TODO: Implement some real logging
			e.printStackTrace();
			System.out.println("Quack!");
			return new ResponseEntity<Topic>( HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
     * @summary upload topic files by id
     *
     * @param id id of the topic item to get
     * @return HTTP response 200 on success with any data if available, HTTP 400 error if performed
     * @url /UploadTopicFiles/{id}
     */
	@PostMapping(value="/UploadTopicFiles/{id}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> uploadTopicFiles(@PathVariable Long id, @ModelAttribute FileUploadListDto fileUploadListDto)
	{
		
		try
		{
			System.out.println(fileUploadListDto.getFiles()[0].getOriginalFilename());
			//System.out.println("UserID: "+newTopicDto.getUuid());
			//Topic topic = topicService.updateTopic(newTopicDto);
			Topic topic = null;
			
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		} 
		catch (Exception e)
		{
			//TODO: Implement some real logging
			e.printStackTrace();
			System.out.println("Quack!");
			return new ResponseEntity<String>("Fail", HttpStatus.BAD_REQUEST);
		}
	}
}
