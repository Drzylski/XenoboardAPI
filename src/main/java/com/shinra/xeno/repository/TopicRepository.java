package com.shinra.xeno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.shinra.xeno.model.Topic;

/**
 * @author Damian Zylski
 * @since 7/31/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Topic Repository. Queries and handles all topic data from the topic table in DB
 */

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>
{
	
	//Get all topics by not deleted and ordered by created date
	List <Topic[]> findByDeletedFalseOrderByCreatedOnDesc();
	
	//Get all topics by user id ordered by created date
	//TODO: Create a dto to serialize this data
    @Query(value = "SELECT t.id AS topicId, u.id AS userId, t.uuid, t.created_on, t.created_by_id,  t.title, t.body " +
    		"FROM (topic t, user u) " +
            "WHERE t.created_by_id = u.id AND t.deleted = false " +
            "ORDER BY t.created_on DESC" ,nativeQuery = true)
    List <Object[]> getAllTopicsByUserId(@Param("userId") long userId);
}
