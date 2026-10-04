package com.shinra.xeno.RepositoryTests;

/**
 * @author Damian Zylski
 * @since 9/15/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary SiteContentRepositoryTest - Test Data JPA repository queries
 */

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.shinra.xeno.model.SiteContent;
import com.shinra.xeno.repository.SiteContentRepository;

@DataJpaTest(properties = {
	    "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=MySQL;NON_KEYWORDS=USER",
	    "spring.jpa.properties.hibernate.show_sql=true",
	    "spring.jpa.defer-datasource-initialization=true",
	    "spring.sql.init.mode:always",
	    "spring.datasource.driver-class-name=org.h2.Driver",
	    //"spring.jpa.properties.hibernate.globally_quoted_identifiers=true",
	    "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
	    "spring.jpa.hibernate.ddl-auto=none"
	})
public class SiteContentRepoTests
{

	@Autowired
	private SiteContentRepository siteContentRepository;
	
	/**
	 * Tests that user is saved correctly
	 */
	@Test
    @Transactional
    @Rollback
	public void testSaveSiteContentSuccess() 
	{
		String testName = "Test: testSaveSiteContentSuccess";
		String title = "Test Content";
		String content = "<div>This is my test content</div>";
		
		SiteContent siteContent = new SiteContent();
		siteContent.setTitle(title);
		siteContent.setContent(content);
		siteContent.setCreatedById(1L);
		siteContent.setUpdatedById(1L);
		
		SiteContent savedContent = siteContentRepository.save(siteContent);
		
		assertThat(savedContent).isNotNull();
		assertThat(savedContent.getId()).isNotNull();
		
		assertThat(savedContent.getTitle()).isEqualTo(title);
		assertThat(savedContent.getContent()).isEqualTo(content);
		
	}
	
	/**
	 * Tests that user is found by id
	 */
	@Test
    @Transactional
    @Rollback
	public void testGetSiteContentByIdFound() 
	{
		String testName = "Test: testSaveSiteContentSuccess";
		String title = "Test Content";
		String content = "<div>This is my test content</div>";
		
		SiteContent siteContent = new SiteContent();
		siteContent.setTitle(title);
		siteContent.setContent(content);
		
        Optional<SiteContent> savedContent = siteContentRepository.findById(1L);

        assertThat(savedContent.get()).isNotNull();
	}
	
}
