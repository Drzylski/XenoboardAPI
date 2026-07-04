package com.shinra.xeno.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author Damian Zylski
 * @since 6/29/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Site Content class. Contains text and html used in various areas of the site
 */

@Entity
@Table(name="site_content")
public class SiteContent extends BaseEntity
{
	@Column(name = "title", nullable = false, length = 40)
	private String title;
	@Column(name = "content", nullable = false, length = 3000)
	private String content;
	
	public SiteContent()
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

	@Override
	public String toString()
	{
		return "SiteContent [title=" + title + ", content=" + content + "]";
	}
	
	
}
