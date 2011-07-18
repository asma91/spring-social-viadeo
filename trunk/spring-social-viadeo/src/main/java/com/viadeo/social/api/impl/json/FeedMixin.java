package com.viadeo.social.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.viadeo.social.api.News;

/**
 * Annotated mixin to add Jackson annotations to ViadeoProfile.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class FeedMixin {

	@JsonCreator
	FeedMixin(@JsonProperty("data") List<News> news) {
	}

}
