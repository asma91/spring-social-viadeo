package com.viadeo.social.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import com.viadeo.social.api.Viadeo;

public class ViadeoConnectionFactory extends OAuth2ConnectionFactory<Viadeo> {

	public ViadeoConnectionFactory(String clientId, String clientSecret) {
		super("viadeo", new ViadeoServiceProvider(clientId, clientSecret), new ViadeoApiAdapter());
	}
	
}