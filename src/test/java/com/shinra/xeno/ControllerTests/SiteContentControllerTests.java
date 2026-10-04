package com.shinra.xeno.ControllerTests;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.shinra.xeno.model.SiteContent;
import com.shinra.xeno.security.SecurityConfig;
import com.shinra.xeno.service.SiteContentService;
import com.shinra.xeno.controller.SiteContentController;

/**
 * @author Damian Zylski
 * @since 9/15/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary SiteContentControllerTest - Test controller methods associated with Site Content
 */

@WebMvcTest(SiteContentController.class)
//@ContextConfiguration(classes={SecurityConfig.class})
@Import(SecurityConfig.class)
public class SiteContentControllerTests
{
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private SiteContentService siteContentService;
	
	//Test success get site content
	@Test
	public void getSiteContentSuccess() throws Exception
	{
		Long contentId = 1L;
		String id = "1";
		String userId = "666";
		
		
		when(siteContentService.getSiteContent(contentId)).thenReturn(new SiteContent());
		
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost8080/SiteContent/GetSiteContent/"+contentId)
				.contentType(MediaType.APPLICATION_JSON)
				//.content(id)
				.param("id", id)
				.param("userId", userId)
				)
				.andExpect(MockMvcResultMatchers.status().isOk());
				
	}
}
