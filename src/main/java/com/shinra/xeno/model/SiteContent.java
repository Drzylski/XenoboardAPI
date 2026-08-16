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
public class SiteContent extends Content
{
	
	public SiteContent()
	{
		super();
	}

	@Override
	public String toString()
	{
		return "SiteContent [title=" + this.getTitle() + ", content=" + this.getContent() + "]";
	}
	
	
}
