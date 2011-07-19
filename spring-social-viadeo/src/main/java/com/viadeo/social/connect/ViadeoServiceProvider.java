package com.viadeo.social.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

import com.viadeo.social.api.Viadeo;
import com.viadeo.social.api.impl.ViadeoTemplate;

public final class ViadeoServiceProvider extends
		AbstractOAuth2ServiceProvider<Viadeo> {

	public ViadeoServiceProvider(String clientId, String clientSecret) {
		super(new OAuth2Template(clientId, clientSecret,
				"https://graph.facebook.com/oauth/authorize",
				"https://graph.facebook.com/oauth/access_token"));
	}

	@Override
	public Viadeo getApi(String accessToken) {
		return new ViadeoTemplate(accessToken);
	}

}
