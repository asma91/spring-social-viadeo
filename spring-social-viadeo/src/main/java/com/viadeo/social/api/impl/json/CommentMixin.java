package com.viadeo.social.api.impl.json;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.viadeo.social.api.ViadeoProfile;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CommentMixin {

	@JsonCreator
	CommentMixin(@JsonProperty("id") String id, @JsonProperty("message")String message, @JsonProperty("from")ViadeoProfile from,
			@JsonProperty("data")Date created_time) {
	}
}
