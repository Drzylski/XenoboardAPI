package com.shinra.xeno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shinra.xeno.model.SiteContent;

/**
 * @author Damian Zylski
 * @since 6/29/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Site Content Repository. Queries and handles all site content data from the site content table in DB
 */

@Repository
public interface SiteContentRepository extends JpaRepository<SiteContent, Long>
{

}
