package com.viadeo.social.api;

import java.util.List;


public interface ConnectionsOperations {


	/**
	 * Retrieves the 1st-degree connections from the current user's network.
	 * 
	 * @return the user's connections
	 */
	List<ViadeoProfile> getConnections();
}
