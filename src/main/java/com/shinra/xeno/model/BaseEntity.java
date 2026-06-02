package com.shinra.xeno.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


/*
 * Programmer: Damian Zylski
 * Date: 5/15/26
 * System: Windows 10 - Eclipse
 * 
 * The class serves as the base entity for every entity. All Entities extend this class
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity extends com.shinra.xeno.model.Auditable implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "uuid", nullable = false, length = 36)
	private String uuid = UUID.randomUUID().toString();
	
	@Column(name = "deleted", nullable = false)
	private boolean deleted;

	private static final long serialVersionUID = 1L;

	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid()
	{
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}

	/**
	 * @return the deleted
	 */
	public boolean isDeleted()
	{
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted)
	{
		this.deleted = deleted;
	}

	/**
	 * @summary hashCode - Hashing based on entity ID
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(id);
	}

	/**
	 * @summary equals - Comparison based on entity ID
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!(obj instanceof BaseEntity))
			return false;
		BaseEntity other = (BaseEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	/**
	 * @summary compareTo - Comparison based on entity ID
	 */
	public int compareTo(BaseEntity n)
    {
        if(Long.compare(this.getId(), n.getId()) > 0)
        {
            return 1;
        }
        else if(Long.compare(this.getId(), n.getId()) < 0)
        {
            return -1;
        }
        else if(Long.compare(this.getId(), n.getId()) == 0)
        {
            return 0;
        }

        return 0;
    }
	
	

	
}
