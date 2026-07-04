package com.shinra.xeno.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shinra.xeno.model.User;
import com.shinra.xeno.repository.UserRepository;
import com.shinra.xeno.service.UserService;

/**
 * @author Damian Zylski
 * @since 6/09/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary User service implementation. Handles all business logic related to users
 */

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService
{
	
	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl(JpaRepository<User, Long> baseRepository, UserRepository userRepository)
	{
		super(baseRepository);
		this.userRepository = userRepository;
	}
	
	@Override
	public User registerNewUser()
	{
		User u = findById(1L);
		return null;
	}

}
