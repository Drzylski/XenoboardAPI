package com.shinra.xeno.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * @author Damian Zylski
 * @since 5/19/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Auditable. Provides audit properties for base entity
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U>
{
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false)
	private LocalDateTime createdOn;
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on", nullable = false)
	private LocalDateTime updatedOn;
	
	@CreatedBy
	@Column(name = "created_by_id", nullable = true)
	private Long createdById;
	@LastModifiedBy
	@Column(name = "updated_by_id", nullable = true)
	private Long updatedById;
	
	/**
	 * @return the createdOn
	 */
	public LocalDateTime getCreatedOn()
	{
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(LocalDateTime createdOn)
	{
		this.createdOn = createdOn;
	}

	/**
	 * @return the updatedOn
	 */
	public LocalDateTime getUpdatedOn()
	{
		return updatedOn;
	}

	/**
	 * @param updatedOn the updatedOn to set
	 */
	public void setUpdatedOn(LocalDateTime updatedOn)
	{
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the createdById
	 */
	public Long getCreatedById()
	{
		return createdById;
	}

	/**
	 * @param createdById the createdById to set
	 */
	public void setCreatedById(Long createdById)
	{
		this.createdById = createdById;
	}

	/**
	 * @return the updatedById
	 */
	public Long getUpdatedById()
	{
		return updatedById;
	}

	/**
	 * @param updatedById the updatedById to set
	 */
	public void setUpdatedById(Long updatedById)
	{
		this.updatedById = updatedById;
	}
}
