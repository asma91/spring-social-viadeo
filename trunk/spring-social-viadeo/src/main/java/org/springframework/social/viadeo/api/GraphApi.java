package org.springframework.social.viadeo.api;

/**
 * Defines low-level operations against Viadeo's Graph API
 */
public interface GraphApi {

	/**
	 * Fetches an object.
	 * 
	 * @param objectId
	 *            the Viadeo object's ID
	 * @param type
	 *            the Java type to fetch
	 * @return an Java object representing the requested Viadeo object.
	 */
	<T> T fetchObject(String objectId, Class<T> type);

	static final String GRAPH_API_URL = "https://api.viadeo.com/";

	static final String OBJECT_URL = GRAPH_API_URL + "{objectId}";

}
