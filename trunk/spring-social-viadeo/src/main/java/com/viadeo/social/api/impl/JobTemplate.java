package com.viadeo.social.api.impl;

import java.net.URI;
import java.util.List;

import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

import com.viadeo.social.api.GraphApi;
import com.viadeo.social.api.Job;
import com.viadeo.social.api.JobOperations;
import com.viadeo.social.api.JobsResult;

public class JobTemplate implements JobOperations {

	private final GraphApi graphApi;

	private final RestTemplate restTemplate;

	public JobTemplate(GraphApi graphApi, RestTemplate restTemplate) {
		this.graphApi = graphApi;
		this.restTemplate = restTemplate;
	}

	public List<Job> search(String query) {
		URI uri = URIBuilder.fromUri(GraphApi.GRAPH_API_URL + "search/jobs")
				.queryParam("q", query).queryParam("limit", "50").build();
		return restTemplate.getForObject(uri, JobsResult.class).getJobs();
	}
	
	public Job getJob(String objectId) {
		return graphApi.fetchObject(objectId, Job.class);
	}
}
