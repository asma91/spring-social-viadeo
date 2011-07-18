package com.viadeo.social.api;

public interface ViadeoApi extends GraphApi {

	UserOperations userOperations();

	ConnectionsOperations getConnectionsOperations();
}
