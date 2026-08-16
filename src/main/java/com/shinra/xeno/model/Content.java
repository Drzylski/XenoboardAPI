package com.shinra.xeno.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

/**
 * @author Damian Zylski
 * @since 6/29/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Content class. Contains generic content to be used for various areas. To be a parent for more specific content cases
 */

@MappedSuperclass
public class Content extends BaseEntity
{
	@Column(name = "title", nullable = false, length = 40)
	private String title;
	@Column(name = "content", nullable = false, length = 3000)
	private String content;
	
	public Content()
	{
		super();
	}

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
	
	
}
