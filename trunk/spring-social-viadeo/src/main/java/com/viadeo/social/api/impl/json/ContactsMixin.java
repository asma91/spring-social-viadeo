package com.viadeo.social.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.viadeo.social.api.ViadeoProfile;

/**
 * Annotated mixin to add Jackson annotations to ViadeoProfile.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ContactsMixin {

	@JsonCreator
	ContactsMixin(@JsonProperty("data") List<ViadeoProfile> contacts) {
	}

}
