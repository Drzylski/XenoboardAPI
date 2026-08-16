package com.shinra.xeno.service;

import com.shinra.xeno.dto.NewTopicDto;
import com.shinra.xeno.dto.TopicLikeDTO;
import com.shinra.xeno.model.Topic;

/**
 * @author Damian Zylski
 * @since 7/31/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Topic service interface.
 */

public interface TopicService extends BaseService<Topic, Long>
{
	Topic updateLikes(TopicLikeDTO topicLikeDTO);
	
	Topic updateTopic(NewTopicDto newTopicDto);
}
