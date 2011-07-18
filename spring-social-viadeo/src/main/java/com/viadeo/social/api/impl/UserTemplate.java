package com.viadeo.social.api.impl;

import java.net.URI;
import java.util.List;

import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

import com.viadeo.social.api.Contacts;
import com.viadeo.social.api.GraphApi;
import com.viadeo.social.api.News;
import com.viadeo.social.api.Feed;
import com.viadeo.social.api.UserOperations;
import com.viadeo.social.api.ViadeoProfile;

public class UserTemplate implements UserOperations {

	private final GraphApi graphApi;

	private final RestTemplate restTemplate;

	public UserTemplate(GraphApi graphApi, RestTemplate restTemplate) {
		this.graphApi = graphApi;
		this.restTemplate = restTemplate;
	}

	public ViadeoProfile getUserProfile() {
		return getUserProfile("me");
	}

	public ViadeoProfile getUserProfile(String userId) {
		return graphApi.fetchObject(userId, ViadeoProfile.class);
	}

	public List<ViadeoProfile> getContacts() {
		return getContacts("me");
	}

	public List<ViadeoProfile> getContacts(String userId) {
		URI uri = URIBuilder.fromUri(
				GraphApi.GRAPH_API_URL + userId + "/contacts").queryParam(
				"user_detail", "full").build();
		return restTemplate.getForObject(uri, Contacts.class).getContacts();
	}

	public List<News> getNewsFeed() {
		return getNewsFeed("me");
	}

	public List<News> getNewsFeed(String userId) {
		URI uri = URIBuilder.fromUri(
				GraphApi.GRAPH_API_URL + userId + "/home_newsfeed").queryParam(
				"user_detail", "full").build();
		return restTemplate.getForObject(uri, Feed.class).getNews();
	}
}
