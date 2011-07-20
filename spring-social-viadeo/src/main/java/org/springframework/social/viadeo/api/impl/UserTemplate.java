package org.springframework.social.viadeo.api.impl;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.social.support.URIBuilder;
import org.springframework.social.viadeo.api.Career;
import org.springframework.social.viadeo.api.Experience;
import org.springframework.social.viadeo.api.GraphApi;
import org.springframework.social.viadeo.api.News;
import org.springframework.social.viadeo.api.UserOperations;
import org.springframework.social.viadeo.api.ViadeoProfile;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class UserTemplate extends AbstractViadeoOperations implements
		UserOperations {

	private static final String FULL = "full";

	private static final String ME = "me";

	private static final String USER_DETAIL = "user_detail";

	private final GraphApi graphApi;

	private final RestTemplate restTemplate;

	public UserTemplate(GraphApi graphApi, RestTemplate restTemplate,
			boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.graphApi = graphApi;
		this.restTemplate = restTemplate;
	}

	public ViadeoProfile getUserProfile() {
		requireAuthorization();
		return getUserProfile(ME);
	}

	public ViadeoProfile getUserProfile(String userId) {
		return graphApi.fetchObject(userId, ViadeoProfile.class);
	}

	public List<ViadeoProfile> getContacts() {
		requireAuthorization();
		return getContacts(ME);
	}

	public List<ViadeoProfile> getContacts(String userId) {
		URI uri = URIBuilder.fromUri(
				GraphApi.GRAPH_API_URL + userId + "/contacts").queryParam(
				USER_DETAIL, FULL).build();
		return restTemplate.getForObject(uri, Contacts.class).getContacts();
	}

	public List<News> getNewsFeed() {
		requireAuthorization();
		return getNewsFeed(ME);
	}

	public List<News> getNewsFeed(String userId) {
		URI uri = URIBuilder.fromUri(
				GraphApi.GRAPH_API_URL + userId + "/home_newsfeed").queryParam(
				USER_DETAIL, FULL).queryParam("limit", "50").build();
		return restTemplate.getForObject(uri, Feed.class).getNews();
	}

	public List<Experience> getExperiences() {
		requireAuthorization();
		return getExperiences(ME);
	}

	public List<Experience> getExperiences(String userId) {
		URI uri = URIBuilder.fromUri(
				GraphApi.GRAPH_API_URL + userId + "/career").queryParam(
				USER_DETAIL, FULL).build();
		return restTemplate.getForObject(uri, Career.class).getExperiences();
	}

	public void updateStatus(String status) {
		requireAuthorization();
		if (status.length() > 140) {
			throw new IllegalArgumentException(
					"The message is more than 140 caracters");
		}
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		parts.set("message", status);
		restTemplate.postForObject(GraphApi.GRAPH_API_URL + "status", parts,
				String.class);

	}

	public List<ViadeoProfile> search(String keyword) {
		requireAuthorization();
		URI uri = URIBuilder.fromUri(GraphApi.GRAPH_API_URL + "search/users")
				.queryParam(USER_DETAIL, FULL).queryParam("keyword", keyword)
				.queryParam("limit", "50").build();
		return restTemplate.getForObject(uri, Contacts.class).getContacts();
	}
}
