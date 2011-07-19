package com.viadeo.social.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.viadeo.social.api.Job;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class JobsResultMixin {

	@JsonCreator
	JobsResultMixin(@JsonProperty("data") List<Job> jobs) {
	}
}
