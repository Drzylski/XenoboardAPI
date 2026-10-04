package com.shinra.xeno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Programmer: Damian Zylski
 * Date: 5/12/25
 * System: Windows 10 - Eclipse
 * 
 * Purpose: Xenoboard is a message board application that caters to the Xeno category of games or video games in general. API is a Java springboot Eclipse app. 
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableCaching
@EnableScheduling
public class XenoboardApiApplication 
{
	private static final Logger logger = LoggerFactory.getLogger(XenoboardApiApplication.class);
	
	//The main app//
	public static void main(String[] args) 
	{
		SpringApplication.run(XenoboardApiApplication.class, args);
	}

}
