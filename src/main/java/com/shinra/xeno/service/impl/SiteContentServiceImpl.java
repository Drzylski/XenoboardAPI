package com.shinra.xeno.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shinra.xeno.model.SiteContent;
import com.shinra.xeno.repository.SiteContentRepository;
import com.shinra.xeno.service.SiteContentService;

/**
 * @author Damian Zylski
 * @since 6/29/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Site Content service implementation. Handles all business logic related to site content
 */

@Service
@Transactional
public class SiteContentServiceImpl extends BaseServiceImpl<SiteContent, Long> implements SiteContentService
{
	
	@Autowired
	private SiteContentRepository siteContentRepository;

	public SiteContentServiceImpl(JpaRepository<SiteContent, Long> baseRepository, SiteContentRepository siteContentRepository)
	{
		super(baseRepository);
		this.siteContentRepository = siteContentRepository;
	}
	
	@Transactional(readOnly = true)
	public SiteContent getSiteContent()
	{
		return null;
	}

}
