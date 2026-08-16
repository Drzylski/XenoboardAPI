package com.shinra.xeno.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * @author Damian Zylski
 * @since 7/31/26
 * @implSpec System: Windows 10 - Eclipse
 * 
 * @summary Topic class. A topic is the lifeblood of xeno board
 */

@Entity
@Table(name="topic")
public class Topic extends BaseEntity
{
	@Column(name = "title", nullable = false, length = 200)
	private String title;
	@Column(name = "body", nullable = false, length = 11000)
	private String body;
	@Column(name = "approved", nullable = false)
	private boolean approved;
	@Column(name = "views", nullable = false)
	private int views;
	@Column(name = "likes", nullable = false)
	private int likes;
	@Column(name = "sticky", nullable = false)
	private boolean sticky;
	@Column(name = "closed", nullable = false)
	private boolean closed;
	@Column(name = "reported", nullable = false)
	private boolean reported;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reported_by_date", nullable = true)
	private LocalDateTime reportedByDate;
	@Column(name = "reported_by_reason", nullable = true, length = 255)
	private String reportedByReason;
	@Column(name = "reported_by_id", nullable = true)
	private Long reportedById;
	@Column(name = "category_id", nullable = false)
	private int categoryId;
	
	public Topic()
	{
		super();
	}
	
	public Topic(String uuid)
	{
		super();
		this.setUuid(uuid);
	}

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * @return the body
	 */
	public String getBody()
	{
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body)
	{
		this.body = body;
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
	 * @return the views
	 */
	public int getViews()
	{
		return views;
	}

	/**
	 * @param views the views to set
	 */
	public void setViews(int views)
	{
		this.views = views;
	}

	/**
	 * @return the likes
	 */
	public int getLikes()
	{
		return likes;
	}

	/**
	 * @param likes the likes to set
	 */
	public void setLikes(int likes)
	{
		this.likes = likes;
	}

	/**
	 * @return the sticky
	 */
	public boolean isSticky()
	{
		return sticky;
	}

	/**
	 * @param sticky the sticky to set
	 */
	public void setSticky(boolean sticky)
	{
		this.sticky = sticky;
	}

	/**
	 * @return the closed
	 */
	public boolean isClosed()
	{
		return closed;
	}

	/**
	 * @param closed the closed to set
	 */
	public void setClosed(boolean closed)
	{
		this.closed = closed;
	}

	/**
	 * @return the reported
	 */
	public boolean isReported()
	{
		return reported;
	}

	/**
	 * @param reported the reported to set
	 */
	public void setReported(boolean reported)
	{
		this.reported = reported;
	}

	/**
	 * @return the reportedByDate
	 */
	public LocalDateTime getReportedByDate()
	{
		return reportedByDate;
	}

	/**
	 * @param reportedByDate the reportedByDate to set
	 */
	public void setReportedByDate(LocalDateTime reportedByDate)
	{
		this.reportedByDate = reportedByDate;
	}

	/**
	 * @return the reportedByReason
	 */
	public String getReportedByReason()
	{
		return reportedByReason;
	}

	/**
	 * @param reportedByReason the reportedByReason to set
	 */
	public void setReportedByReason(String reportedByReason)
	{
		this.reportedByReason = reportedByReason;
	}

	/**
	 * @return the reportedById
	 */
	public Long getReportedById()
	{
		return reportedById;
	}

	/**
	 * @param reportedById the reportedById to set
	 */
	public void setReportedById(Long reportedById)
	{
		this.reportedById = reportedById;
	}

	/**
	 * @return the categoryId
	 */
	public int getCategoryId()
	{
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId)
	{
		this.categoryId = categoryId;
	}
	
	/**
	 * @summary toString
	 */
	@Override
	public String toString()
	{
		return "Topic [topic = " + this.getId() + " Title: " + this.getTitle();
	}
}
