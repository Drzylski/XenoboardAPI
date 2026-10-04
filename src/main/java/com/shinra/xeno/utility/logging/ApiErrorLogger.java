package com.shinra.xeno.utility.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shinra.xeno.XenoboardApiApplication;

//Logs api errors

public class ApiErrorLogger
{
	private static final Logger logger = LoggerFactory.getLogger(ApiErrorLogger.class);
	
	//Logs api errors
	public static void logApiError(Exception e) 
	{
		//Loop and log error in stream
        logger.error("\n\n****************************************************************************************************************************************************************");
        logger.error(e.toString());

        for(StackTraceElement element : e.getStackTrace())
        {
            logger.error(element.toString());
        }
        logger.error("***************************************************************************************************************************************************************\n\n");

	}

}
