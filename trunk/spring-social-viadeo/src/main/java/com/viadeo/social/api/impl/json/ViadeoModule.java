package com.viadeo.social.api.impl.json;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;

import com.viadeo.social.api.Contacts;
import com.viadeo.social.api.Feed;
import com.viadeo.social.api.News;
import com.viadeo.social.api.ViadeoProfile;

/**
 * Jackson module for setting up mixin annotations on Viadeo model types. This
 * enables the use of Jackson annotations without directly annotating the model
 * classes themselves.
 */
public class ViadeoModule extends SimpleModule {

	public ViadeoModule() {
		super("ViadeoModule", new Version(1, 0, 0, null));
	}

	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(ViadeoProfile.class,
				ViadeoProfileMixin.class);
		context.setMixInAnnotations(Contacts.class,
				ContactsMixin.class);
		context.setMixInAnnotations(Feed.class,
				FeedMixin.class);
		context.setMixInAnnotations(News.class,
				NewsMixin.class);
	}
}
