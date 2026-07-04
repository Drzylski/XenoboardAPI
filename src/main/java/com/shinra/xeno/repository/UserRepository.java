package com.shinra.xeno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shinra.xeno.model.User;

/**
 * @author Damian Zylski
 * @since 6/02/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary User Repository. Queries and handles all user data from the User table in DB
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

}
