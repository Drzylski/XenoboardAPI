package com.shinra.xeno.dto;

/**
 * @author Damian Zylski
 * @since 7/31/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Topic Likes Dto - For handling topic like updates
 */

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class TopicLikeDTO
{
	private String uuid;
	private int likes;
	private int userId;
}
