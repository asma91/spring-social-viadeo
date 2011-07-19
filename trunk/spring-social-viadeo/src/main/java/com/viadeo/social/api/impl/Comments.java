package com.viadeo.social.api.impl;

import java.io.Serializable;
import java.util.List;

import com.viadeo.social.api.Comment;

public class Comments implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8748950763266683264L;

	private final List<Comment> comments;

	public Comments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Comment> getComments() {
		return comments;
	}

}
