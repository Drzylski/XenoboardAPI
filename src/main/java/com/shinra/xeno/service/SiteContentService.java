package com.shinra.xeno.service;

import com.shinra.xeno.model.SiteContent;

/**
 * @author Damian Zylski
 * @since 6/29/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Site Content service interface.
 */

public interface SiteContentService extends BaseService<SiteContent, Long>
{
	SiteContent getSiteContent();
}
