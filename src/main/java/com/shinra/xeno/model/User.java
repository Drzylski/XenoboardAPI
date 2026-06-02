package com.shinra.xeno.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * @author Damian Zylski
 * @since 5/15/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary User class. Users interact with all other entities.
 */

@Entity
@Table(name="user")
public class User extends BaseEntity
{
	@Column(name = "username", nullable = false, length = 30)
	private String username;
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	@Column(name = "banner", nullable = true, length = 200)
	private String banner;
	@Column(name = "dob", nullable = true)
	private LocalDate dob;
	@Column(name = "approved", nullable = false)
	private boolean approved;

	public User()
	{
		super();
	}
	
	public User( String username, String email)
	{
		super();
		this.username = username;
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * @return the banner
	 */
	public String getBanner()
	{
		return banner;
	}

	/**
	 * @param banner the banner to set
	 */
	public void setBanner(String banner)
	{
		this.banner = banner;
	}

	/**
	 * @return the dob
	 */
	public LocalDate getDob()
	{
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob)
	{
		this.dob = dob;
	}

	/**
	 * @return the approved
	 */
	public boolean isApproved()
	{
		return approved;
	}

	/**
	 * @param approved the approved to set
	 */
	public void setApproved(boolean approved)
	{
		this.approved = approved;
	}

	/**
	 * @summary toString
	 */
	@Override
	public String toString()
	{
		return "User [username = " + username + ", email = " + email + ", id = " + getId() + "]";
	}
	
	
	
}
