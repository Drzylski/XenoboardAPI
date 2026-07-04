package com.shinra.xeno.service;

/**
 * @author Damian Zylski
 * @since 6/09/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Base Service. Common services used by all services
 */

import java.util.List;

import org.springframework.data.domain.Page;

import com.shinra.xeno.model.BaseEntity;

public interface BaseService<E extends BaseEntity, id>
{
	E create(E entity);
	
	E update(E entity);
	
	E updateAuditable(E entity);
	
	long countAll();
    
    E findById(Long id);
    
    E findByUuid(E searchEntity);
    
    List<E> findAll();
    
    void softDelete(Long id);
    
    void delete(Long id);
}
