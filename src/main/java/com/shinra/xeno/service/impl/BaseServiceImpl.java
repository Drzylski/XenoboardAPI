package com.shinra.xeno.service.impl;

import java.time.LocalDateTime;

/**
 * @author Damian Zylski
 * @since 6/09/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Base Service. Common services used by all services
 */

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.shinra.xeno.model.BaseEntity;
import com.shinra.xeno.model.User;
import com.shinra.xeno.service.BaseService;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Transactional
public abstract class BaseServiceImpl <E extends BaseEntity, id> implements BaseService<E, Long>
{
	@Autowired
    private JpaRepository<E, Long> baseRepository;
	
	public BaseServiceImpl(JpaRepository<E, Long> baseRepository)
	{
		super();
		this.baseRepository = baseRepository;
	}
	
	public E create(E entity)
	{
		if(entity.getId() == null) 
		{
			entity = updateAuditable(entity);
			entity = baseRepository.save(entity);
		}
		else 
		{
			 throw new EntityExistsException("Entity with ID "+entity.getId()+" exists");
		}
		
		return entity;
	}
	
	public E update(E entity)
	{
		if(entity.getId() != null) 
		{
			entity = updateAuditable(entity);
			entity = baseRepository.save(entity);
		}
		else 
		{
			 throw new EntityNotFoundException("Entity does not exist");
		}
		
		return entity;
	}
	
	public E updateAuditable(E entity)
	{
		if(entity.getCreatedOn() == null) entity.setCreatedOn(LocalDateTime.now());
		entity.setUpdatedOn(LocalDateTime.now());
		if(entity.getCreatedById() == null) entity.setCreatedById(1L);
		entity.setUpdatedById(1L);
		
		return entity;
	}
	
	public long countAll()
	{
		return baseRepository.count();
	}
    
    public E findById(Long id)
    {
    	Optional<E> entity = baseRepository.findById(id);
    	
    	return entity.orElseThrow();
    }
    
    public E findByUuid(E searchEntity)
    {    	
    	//This example matcher will include any primitives with default value like 0 or false. Must use matchingAny or it will use AND with any of those values. 
    	ExampleMatcher matcher = ExampleMatcher.matchingAny().withMatcher("uuid", match -> match.contains())
    			.withStringMatcher(StringMatcher.CONTAINING).withIgnoreNullValues();
    	
    	Example<E> example = Example.of(searchEntity, matcher);
    	
    	Optional<E> result = baseRepository.findOne(example);
    	
    	return result.orElseThrow();
    }
    
    public List<E> findAll()
    {
    	List<E>items = baseRepository.findAll();
    	
    	return items;
    }
    
    public void softDelete(Long id)
    {
    	E entity = this.findById(id);
    	
    	entity.setDeleted(!entity.isDeleted());
    	
    	entity = this.update(entity);
    }
    
    public void delete(Long id)
    {
    	E entity = this.findById(id);
    	
    	baseRepository.deleteById(entity.getId());
    }
}
