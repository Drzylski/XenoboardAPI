package com.shinra.xeno.security;

/**
 * @author Damian Zylski
 * @since 6/15/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Main security config file for the xenoboard api
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig
{
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
		
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers(HttpMethod.GET,"/").permitAll()
				.anyRequest().permitAll()
				//.anyRequest().authenticated()
		);
//		http.oauth2Login((login) ->
//			login.redirectionEndpoint((endpoint) ->
//				endpoint.baseUri("/login/oauth2/callback/*")
//			)
//		);
		return http.build();
	}

}
