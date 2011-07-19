package com.viadeo.social.api.impl.json;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ExperienceMixin {

	ExperienceMixin(@JsonProperty("id") String id,
			@JsonProperty("position") String position,
			@JsonProperty("description") String description,
			@JsonProperty("companyName") String companyName) {
	}

	@JsonProperty("begin")
	Integer beginYear;

	@JsonProperty("end")
	Integer endYear;
}
