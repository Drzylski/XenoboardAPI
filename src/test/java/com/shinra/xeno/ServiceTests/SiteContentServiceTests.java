package com.shinra.xeno.ServiceTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.assertj.core.api.Assertions.assertThatRuntimeException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.shinra.xeno.model.SiteContent;
import com.shinra.xeno.repository.SiteContentRepository;
import com.shinra.xeno.service.SiteContentService;
import com.shinra.xeno.service.impl.SiteContentServiceImpl;

/**
 * @author Damian Zylski
 * @since 9/15/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary SiteContentServiceTest - Test services associated with Site Content
 */

@ExtendWith(MockitoExtension.class)
public class SiteContentServiceTests
{
	@Mock
	private SiteContentRepository siteContentRepository;
	
	@InjectMocks
	private SiteContentServiceImpl siteContentService;
	
	@BeforeEach
    void setUp() {
        //Test data
		Long id = 1L;
        SiteContent siteContent = new SiteContent();
        siteContent.setContent("<div>Content</div>");
        siteContent.setTitle("Homepage Lower Register Text");
        siteContent.setId(id);
        
        //TRY REPO INSTEAD OF SERVICE HERE
        Mockito.when(siteContentRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(siteContent));
    }
	 
	
	//Tests getSiteContent for getting sitecontent by id
	@Test
	public void getSiteContentSuccess(){
		
		SiteContent content = siteContentService.getSiteContent(1L);
		
		verify(siteContentRepository, times(1)).findById(1L);
		
		assertThat(content).isNotNull();
		assertThat(content.getId()).isEqualTo(1);
		
	}
	
	//Tests getSiteContent for getting sitecontent by id fail
		@Test
		public void getSiteContentFail(){
			
			Mockito.when(siteContentRepository.findById(-1L)).thenReturn(Optional.ofNullable(null));
			
			NoSuchElementException exception = assertThrows(
					NoSuchElementException.class,
			        () -> {siteContentService.getSiteContent(-1L);}
			    );
			
			verify(siteContentRepository, times(1)).findById(-1L);
			
			assertEquals(NoSuchElementException.class, exception.getClass());
			
		}
}
