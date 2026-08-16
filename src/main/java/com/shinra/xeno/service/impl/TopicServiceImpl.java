package com.shinra.xeno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shinra.xeno.dto.NewTopicDto;
import com.shinra.xeno.dto.TopicLikeDTO;
import com.shinra.xeno.model.Topic;
import com.shinra.xeno.model.User;
import com.shinra.xeno.repository.TopicRepository;
import com.shinra.xeno.service.TopicService;

/**
 * @author Damian Zylski
 * @since 7/31/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Topic service implementation. Handles all business logic related to topics
 */

@Service
@Transactional
public class TopicServiceImpl  extends BaseServiceImpl<Topic, Long> implements TopicService
{
	@Autowired
	private TopicRepository topicRepository;
	
	public TopicServiceImpl(JpaRepository<Topic, Long> baseRepository, TopicRepository topicRepository)
	{
		super(baseRepository);
		this.topicRepository = topicRepository;
	}
	
	//Updates a topics likes
	public Topic updateLikes(TopicLikeDTO topicLikeDTO)
	{
		//Get topic by uuid
		Topic topic = this.findByUuid(new Topic(topicLikeDTO.getUuid()));
		
		//update likes
		topic.setLikes(topicLikeDTO.getLikes());
		
		//Save
		topic = this.update(topic);
		
		return topic;
	}
	
	//Updates a topics likes
	//TODO: This is right now updating topic likes only for testing purposes. This service will be updated in the future
		public Topic updateTopic(NewTopicDto newTopicDto)
		{
			//Get topic by uuid
			Topic topic = this.findByUuid(new Topic(newTopicDto.getUuid()));
			
			List <Object[]> queryList = topicRepository.getAllTopicsByUserId(1); //For testing only
			List <Topic[]> topicList = topicRepository.findByDeletedFalseOrderByCreatedOnDesc(); //for testing only
			
			System.out.println("Topic: "+newTopicDto);
			
			//update 
			topic.setLikes(777);
			
			//Save
			topic = this.update(topic);
			
			return topic;
		}
}
