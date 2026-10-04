package com.shinra.xeno.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

//Catches exceptions not caught by controllers and logs them

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shinra.xeno.XenoboardApiApplication;
import com.shinra.xeno.utility.logging.ApiErrorLogger;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class DefaultExceptionHandler
{
	private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

	@ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Exception> genericException(Exception e)
    {      
    	logger.error("Default:\n*********"+e.getMessage()+"*********\n");
    	ApiErrorLogger.logApiError(e);
    	return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
