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
 * @summary File Upload List Dto. For uploading or handling a list of files
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FileUploadListDto
{
	private long id;
	private MultipartFile [] files;
}
