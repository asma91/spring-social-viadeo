package com.viadeo.social.api.impl;

import java.net.URI;
import java.util.List;

import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

import com.viadeo.social.api.GraphApi;
import com.viadeo.social.api.Job;
import com.viadeo.social.api.JobOperations;

public class JobTemplate extends AbstractViadeoOperations implements JobOperations {

	private final GraphApi graphApi;

	private final RestTemplate restTemplate;

	public JobTemplate(GraphApi graphApi, RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.graphApi = graphApi;
		this.restTemplate = restTemplate;
	}

	public List<Job> search(String query) {
		requireAuthorization();
		URI uri = URIBuilder.fromUri(GraphApi.GRAPH_API_URL + "search/jobs")
				.queryParam("q", query).queryParam("limit", "50").build();
		return restTemplate.getForObject(uri, JobsResult.class).getJobs();
	}
	
	public Job getJob(String objectId) {
		requireAuthorization();
		return graphApi.fetchObject(objectId, Job.class);
	}
}
