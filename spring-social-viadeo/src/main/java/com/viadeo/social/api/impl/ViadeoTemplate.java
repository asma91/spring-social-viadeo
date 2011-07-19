package com.viadeo.social.api.impl;

import java.net.URI;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.ResourceAccessException;

import com.viadeo.social.api.JobOperations;
import com.viadeo.social.api.GraphAPIException;
import com.viadeo.social.api.UserOperations;
import com.viadeo.social.api.ViadeoApi;
import com.viadeo.social.api.impl.json.ViadeoModule;

public class ViadeoTemplate extends AbstractOAuth2ApiBinding implements
		ViadeoApi {

	private UserOperations userOperations;

	private JobOperations jobOperations;

	/**
	 * Create a new instance of ViadeoTemplate. This constructor creates the
	 * ViadeoTemplate using a given access token.
	 * 
	 * @param accessToken
	 *            An access token given by Viadeo after a successful OAuth 2
	 *            authentication.
	 */
	public ViadeoTemplate(String accessToken) {
		super(accessToken);
		super.setRequestFactory(ClientHttpRequestFactorySelector
				.bufferRequests(getRestTemplate().getRequestFactory()));
		registerViadeoModule();

		// sub-apis
		userOperations = new UserTemplate(this, getRestTemplate());
		jobOperations = new JobTemplate(this, getRestTemplate());
	}

	private void registerViadeoModule() {
		List<HttpMessageConverter<?>> converters = getRestTemplate()
				.getMessageConverters();
		for (HttpMessageConverter<?> converter : converters) {
			if (converter instanceof MappingJacksonHttpMessageConverter) {
				MappingJacksonHttpMessageConverter jsonConverter = (MappingJacksonHttpMessageConverter) converter;
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.registerModule(new ViadeoModule());
				jsonConverter.setObjectMapper(objectMapper);
			}
		}
	}

	public <T> T fetchObject(String objectId, Class<T> type) {
		try {
			URI uri = URIBuilder.fromUri(GRAPH_API_URL + objectId).build();
			return getRestTemplate().getForObject(uri, type);
		} catch (ResourceAccessException e) {
			// Handle the special case where an unknown alias results in an
			// error returned as a HTTP 200
			if (e.getCause() instanceof UnrecognizedPropertyException) {
				UnrecognizedPropertyException jsonException = (UnrecognizedPropertyException) e
						.getCause();
				if (jsonException.getUnrecognizedPropertyName().equals("error")) {
					throw new GraphAPIException("Unknown alias: " + objectId);
				}
			}
			throw new GraphAPIException("Unexpected graph API exception", e
					.getCause());
		}
	}

	public UserOperations userOperations() {
		return userOperations;
	}

	public JobOperations jobOperations() {
		return jobOperations;
	}

}
