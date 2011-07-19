package com.viadeo.social.api.impl;

import org.springframework.social.MissingAuthorizationException;

abstract class AbstractViadeoOperations {
	private final boolean isAuthorized;

	public AbstractViadeoOperations(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}
	
	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException();
		}
	}
}
