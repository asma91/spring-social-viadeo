package org.springframework.social.showcase;

import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.view.RedirectView;

public class ExtendedConnectController extends ConnectController {

	public ExtendedConnectController(ConnectionFactoryLocator connectionFactoryLocator,
			ConnectionRepository connectionRepository) {
		super(connectionFactoryLocator, connectionRepository);
	}

	/**
	 * Process a connect form submission by commencing the process of establishing a connection to the provider on behalf
	 * of the member. For OAuth1, fetches a new request token from the provider, temporarily stores it in the session,
	 * then redirects the member to the provider's site for authorization. For OAuth2, redirects the user to the
	 * provider's site for authorization.
	 */
	@Override
	@RequestMapping(value = "/{providerId}", method = RequestMethod.POST)
	public RedirectView connect(@PathVariable String providerId, NativeWebRequest request) {
		request.removeAttribute("org.springframework.web.servlet.HandlerMapping.uriTemplateVariables",
				RequestAttributes.SCOPE_REQUEST);
		return super.connect(providerId, request);
	}

}
