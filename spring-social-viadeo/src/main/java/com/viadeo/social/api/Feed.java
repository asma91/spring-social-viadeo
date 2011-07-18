package com.viadeo.social.api;

import java.io.Serializable;
import java.util.List;

public class Feed implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4312798721744954030L;

	private final List<News> news;

	public Feed(List<News> news) {
		this.news = news;
	}

	public List<News> getNews() {
		return news;
	}
}
