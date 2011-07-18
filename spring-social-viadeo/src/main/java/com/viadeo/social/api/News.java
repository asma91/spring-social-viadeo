package com.viadeo.social.api;

import java.io.Serializable;
import java.util.Date;

/**
 * Model class representing an entry in a feed.
 */
public class News implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2489468015293993653L;

	private final String id;

	private final String message;

	private final ViadeoProfile from;

	private final Date creationDate;

	private final Date updatedDate;

	public News(String id, String message, ViadeoProfile from,
			Date creationDate, Date updatedDate) {
		this.id = id;
		this.message = message;
		this.from = from;
		this.creationDate = creationDate;
		this.updatedDate = updatedDate;
	}

	public String getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public ViadeoProfile getFrom() {
		return from;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

}
