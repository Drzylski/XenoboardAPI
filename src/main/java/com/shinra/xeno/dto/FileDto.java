package com.shinra.xeno.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Damian Zylski
 * @since 8/01/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary file Dto - For handling files
 */

@Data
@NoArgsConstructor
@Getter
@Setter
public class FileDto
{
	private long fileSize;
	private String filename;
	private String path;
	private String extension;
	private String file; //Base 64 rep of file
	private String comment;
}
