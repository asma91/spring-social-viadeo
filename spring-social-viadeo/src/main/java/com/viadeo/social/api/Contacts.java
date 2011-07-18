package com.viadeo.social.api;

import java.io.Serializable;
import java.util.List;

/**
 * A model class containing a list of a user's connections on Viadeo.
 */
public class Contacts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9109438495194439081L;

	private final List<ViadeoProfile> contacts;

	public Contacts(List<ViadeoProfile> contacts) {
		this.contacts = contacts;
	}

	public List<ViadeoProfile> getContacts() {
		return contacts;
	}
}
