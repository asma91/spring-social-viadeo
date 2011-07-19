package com.viadeo.social.api.impl;

import java.net.URI;
import java.util.List;

import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

import com.viadeo.social.api.Career;
import com.viadeo.social.api.Contacts;
import com.viadeo.social.api.Experience;
import com.viadeo.social.api.Feed;
import com.viadeo.social.api.GraphApi;
import com.viadeo.social.api.News;
import com.viadeo.social.api.UserOperations;
import com.viadeo.social.api.ViadeoProfile;

public class UserTemplate implements UserOperations {

	private static final String FULL = "full";

	private static final String ME = "me";

	private static final String USER_DETAIL = "user_detail";

	private final GraphApi graphApi;

	private final RestTemplate restTemplate;

	public UserTemplate(GraphApi graphApi, RestTemplate restTemplate) {
		this.graphApi = graphApi;
		this.restTemplate = restTemplate;
	}

	public ViadeoProfile getUserProfile() {
		return getUserProfile(ME);
	}

	public ViadeoProfile getUserProfile(String userId) {
		return graphApi.fetchObject(userId, ViadeoProfile.class);
	}

	public List<ViadeoProfile> getContacts() {
		return getContacts(ME);
	}

	public List<ViadeoProfile> getContacts(String userId) {
		URI uri = URIBuilder.fromUri(
				GraphApi.GRAPH_API_URL + userId + "/contacts").queryParam(
				USER_DETAIL, FULL).build();
		return restTemplate.getForObject(uri, Contacts.class).getContacts();
	}

	public List<News> getNewsFeed() {
		return getNewsFeed(ME);
	}

	public List<News> getNewsFeed(String userId) {
		URI uri = URIBuilder.fromUri(
				GraphApi.GRAPH_API_URL + userId + "/home_newsfeed").queryParam(
				USER_DETAIL, FULL).queryParam(
						"limit", "50").build();
		return restTemplate.getForObject(uri, Feed.class).getNews();
	}

	public List<Experience> getExperiences() {
		return getExperiences(ME);
	}

	public List<Experience> getExperiences(String userId) {
		URI uri = URIBuilder.fromUri(
				GraphApi.GRAPH_API_URL + userId + "/career").queryParam(
				USER_DETAIL, FULL).build();
		return restTemplate.getForObject(uri, Career.class).getExperiences();
	}
}
