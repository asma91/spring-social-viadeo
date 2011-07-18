package com.viadeo.social.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import com.viadeo.social.api.ViadeoApi;

public class ViadeoConnectionFactory extends OAuth2ConnectionFactory<ViadeoApi> {

	public ViadeoConnectionFactory(String clientId, String clientSecret) {
		super("viadeo", new ViadeoServiceProvider(clientId, clientSecret), new ViadeoApiAdapter());
	}
	
}