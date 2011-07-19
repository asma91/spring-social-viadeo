package com.viadeo.social.api;

import org.springframework.social.ApiBinding;

import com.viadeo.social.api.impl.ViadeoTemplate;

/**
 * Interface specifying a basic set of operations for interacting with Viadeo.
 * Implemented by {@link ViadeoTemplate}.
 */
public interface Viadeo extends GraphApi, ApiBinding {

	UserOperations userOperations();

	JobOperations jobOperations();
}
