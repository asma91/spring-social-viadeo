package org.springframework.social.viadeo.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.viadeo.api.Comment;


@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CommentsMixin {

	@JsonCreator
	CommentsMixin(@JsonProperty("data") List<Comment> comments) {
	}
}
