package org.springframework.social.viadeo.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.viadeo.api.Viadeo;
import org.springframework.social.viadeo.api.impl.ViadeoTemplate;


public final class ViadeoServiceProvider extends
		AbstractOAuth2ServiceProvider<Viadeo> {

	public ViadeoServiceProvider(String clientId, String clientSecret) {
		super(new OAuth2Template(clientId, clientSecret,
				"https://secure.viadeo.com/oauth-provider/authorize2",
				"https://secure.viadeo.com/oauth-provider/access_token2"));
	}

	@Override
	public Viadeo getApi(String accessToken) {
		return new ViadeoTemplate(accessToken);
	}

}
