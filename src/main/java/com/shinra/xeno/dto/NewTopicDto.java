package com.shinra.xeno.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Damian Zylski
 * @since 8/01/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Topic create Dto - For handling topic  creation and updates
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewTopicDto
{
	private long id;
	private String uuid;
	private String title;
	private String body;
	private int category;
	private String [] tags;
	private MultipartFile [] files;
	private boolean update;
}
